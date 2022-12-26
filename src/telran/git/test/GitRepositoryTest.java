package telran.git.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.junit.jupiter.api.TestMethodOrder;
import java.util.*;
import telran.git.model.*;
import telran.git.service.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GitRepositoryTest {
GitRepository gitRepository;
static final String FILE1 = "file1.txt";
static final String FILE2 = "file2.txt";
static final String FILE3 = "file2.txt";
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Files.deleteIfExists(Path.of(GitRepository.GIT_FILE));
		Files.deleteIfExists(Path.of(FILE1));
		Files.deleteIfExists(Path.of(FILE2));
		Files.deleteIfExists(Path.of(FILE3));
		
		
		
		
	}
	@BeforeEach
	void setUp() throws Exception {
		gitRepository = GitRepositoryImpl.init();
	}

	@Test
	@Order(1)
	@DisplayName("testing methods init, save, adding regex")
	void initSaveTest() throws Exception {
		
		gitRepository = GitRepositoryImpl.init();
		assertEquals(2, gitRepository.addIgnoredFileNameExp("\\..*").split("\\|").length);
		gitRepository.save();
		gitRepository = GitRepositoryImpl.init();
		assertEquals(3, gitRepository.addIgnoredFileNameExp(".*\\.").split("\\|").length);
		
	}
	@Test
	void infoTest() throws IOException {
		Files.createFile(Path.of(FILE1));
		List<FileState> states = gitRepository.info();
		assertEquals(1, states.size());
		assertEquals(new FileState(Path.of(FILE1), Status.UNTRACKED), states.get(0));
		gitRepository.commit("file1 commit");
		states = gitRepository.info();
		assertEquals(new FileState(Path.of(FILE1), Status.COMMITTED), states.get(0));
		
	}

}
