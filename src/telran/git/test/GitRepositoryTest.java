package telran.git.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.junit.jupiter.api.TestMethodOrder;

import telran.git.service.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GitRepositoryTest {
private static final String WORKING_TREE = "working-tree";
GitRepository gitRepository;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Path workingDirectory = Path.of(".");
		
		
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
	@Order(1)
	@DisplayName("testing methods init, save, adding regex")
	void initSaveTest() throws Exception {
		
		gitRepository = GitRepositoryImpl.init();
		assertEquals(2, gitRepository.addIgnoredFileNameExp(".*\\.").split("\\|").length);
		gitRepository.save();
		gitRepository = GitRepositoryImpl.init();
		assertEquals(3, gitRepository.addIgnoredFileNameExp(".*\\.").split("\\|").length);
		
	}

}
