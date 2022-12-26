package telran.git.controller;

import static org.hamcrest.CoreMatchers.containsString;

import telran.git.service.GitRepository;
import telran.view.*;

public class GitMenu {
	private static GitRepository gitRepository;
public static Item[] getGitRepositoryItems(GitRepository gitRepository) {
	GitMenu.gitRepository = gitRepository;
	Item [] itemsRes = {
		Item.of("commit", GitMenu::commitMethod),
		Item.of("info", GitMenu::infoMethod),
		Item.of("create branch", GitMenu::createBranchMethod),
		Item.of("rename branch", GitMenu::renameBranchMethod),
		Item.of("delete branch", GitMenu::deleteBranchMethod),
		Item.of("log", GitMenu::logMethod),
		Item.of("branches list", GitMenu::branchesMethod),
		Item.of("commit content", GitMenu::commitContentMethod),
		Item.of("switch to", GitMenu::switchToMethod),
		Item.of("add ignore regex", GitMenu::addRegexMethod),
		Item.of("exit", io -> gitRepository.save(), true)
	};
	return itemsRes;
}
static void commitMethod(InputOutput io) {
	String commitMessage = io.readString("Enter commit message");
	io.writeLine(gitRepository.commit(commitMessage));
}
static void addRegexMethod(InputOutput io) {
	String commitMessage = io.readPredicate("Enter regular expression", "Wrong regular expression",
			e -> {
				boolean res = true;
				try {
					"test".matches(e);
				} catch (Exception e1) {
					res = false;
				}
				return res;
			});
	io.writeLine(gitRepository.commit(commitMessage));
}
static void commitContentMethod(InputOutput io) {
	String commitName = io.readString("Enter commit name");
	io.writeLine(gitRepository.commitContent(commitName));
}
static void switchToMethod(InputOutput io) {
	String commitBranch = io.readString("Enter either branch or commit name for switching to");
	io.writeLine(gitRepository.switchTo(commitBranch));
}
static void infoMethod(InputOutput io) {
	gitRepository.info().forEach(io::writeLine);
}
static void createBranchMethod(InputOutput io) {
	String branchName = enterBranchName(io, "branch name");
	io.writeLine(gitRepository.createBranch(branchName));
}
static void renameBranchMethod(InputOutput io) {
	String branchName = enterBranchName(io, "old branch name");
	if(isExist(branchName)) {
		String newBranchName = enterBranchName(io, "new branch name");
		io.writeLine(gitRepository.renameBranch(branchName, newBranchName));
	} else {
		io.writeLine("branch doesn't exist");
	}
	
}
static void deleteBranchMethod(InputOutput io) {
	String branchName = enterBranchName(io, "branch name");
	if(isExist(branchName)) {
		io.writeLine(gitRepository.deleteBranch(branchName));
	} else {
		io.writeLine("branch doesn't exist");
	}
	
}
private static boolean isExist(String branchName) {
	return gitRepository.branches().stream().anyMatch(name -> name.contains(branchName));
}
private static String enterBranchName(InputOutput io, String prompt) {
	return io.readPredicate("Enter " + prompt, "Wrong Branch name",
			t -> t.matches("\\w{4,}"));
}
static void logMethod(InputOutput io) {
	gitRepository.log().forEach(io::writeLine);
}
static void branchesMethod(InputOutput io) {
	gitRepository.branches().forEach(io::writeLine);
}
}
