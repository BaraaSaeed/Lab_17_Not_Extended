import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Copyright (c) 2019. This program and the accompanying materials are made
 * available under my granted permission provided that this note is kept intact,
 * unmodified and unchanged. @ Author: Baraa Ali - API and implementation. All
 * rights reserved.
 */

public class CountriesTextFile {

	private Path filePath;

	public CountriesTextFile(Path filePath) {
		this.filePath = filePath;
	}

	public CountriesTextFile(String filePath) {
		this(Paths.get(filePath));
	}

	public void ensureFileExists() throws IOException {
		if (Files.notExists(filePath)) {
			Files.createFile(filePath);
		}
	}

	public List<String> readFile() {
		// ** Example of reading a file into a list
		try {
			return Files.readAllLines(filePath);
		} catch (FileNotFoundException ex) {
			return new ArrayList<>();
		} catch (IOException ex) {
			ex.printStackTrace();
			return new ArrayList<>();
		}
	}

	public void appendToFile(Country country) throws IOException {
		ensureFileExists();
		String line = country.toString();
		List<String> linesToAdd = Arrays.asList(line);
		// Write those lines to the end of the file
		Files.write(filePath, linesToAdd, StandardOpenOption.APPEND);
	}

}
