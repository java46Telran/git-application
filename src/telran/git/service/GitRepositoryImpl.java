package telran.git.service;

import java.nio.file.Path;
import java.util.List;

import telran.git.model.CommitMessage;
import telran.git.model.FileState;

public class GitRepositoryImpl implements GitRepository{

	
	private static final long serialVersionUID = 1L;
	private GitRepositoryImpl() {
		// TODO Auto-generated constructor stub
	}
	public static GitRepository init() {
		//TODO
		return null;
	}

	@Override
	public String commit(String commitMessage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FileState> info() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createBranch(String branchName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String renameBranch(String branchName, String newName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteBranch(String branchName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommitMessage> log() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> branches() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Path> commitContent(String commitName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String switchTo(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHead() {
		// not implemented yet
		return null;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

}
