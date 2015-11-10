package org.ram;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileMover {

	public void move(String from, String to) {
		Path fromPath = Paths.get(from);
		Path toPath = Paths.get(to, getFilePattern(fromPath.getFileName()));

		try {
			Files.move(fromPath, toPath, StandardCopyOption.ATOMIC_MOVE);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private String getFilePattern(Path path) {
		String fileName = path.getFileName().toString();
		fileName = fileName.substring(0, fileName.lastIndexOf("."));
		return fileName + ".txt";
	}

	public static void main(String[] args) {
		new FileMover().move("C:/Users/capiot/Desktop/temp/mule-example-files/customers-10-11-15_15-18-55.888.tmp",
				"C:/Users/capiot/Desktop/temp/mule-example-files");
	}
}
