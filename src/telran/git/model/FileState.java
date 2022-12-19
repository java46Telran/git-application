package telran.git.model;

import java.nio.file.Path;

public class FileState {
public Path path;
public Status status;
@Override
public String toString() {
	return String.format("%s: %s", path, status);
}
}
