package telran.git.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import telran.git.service.*;

class GitRepositoryTest {
private static final String WORKING_TREE = "working-tree";
GitRepository gitRepository;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Path workingDirectory = Path.of(WORKING_TREE);
		if (!Files.exists(workingDirectory)) {
			Files.createDirectory(workingDirectory);
		}
		
		Files.list(workingDirectory).filter(Files::isRegularFile)
		.forEach(t -> {
			try {
				Files.delete(t);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
