import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
 * Copyright (c) 2019. This program and the accompanying materials are made
 * available under my granted permission provided that this note is kept intact,
 * unmodified and unchanged. @ Author: Baraa Ali - API and implementation. All
 * rights reserved.
 */

public class CountriesApp {
	static Scanner scnr = new Scanner(System.in);
	private static Path filePath = Paths.get("countries.txt");

	public static void main(String[] args) throws IOException {
		run();
	}/* End of main */

	public static void run() throws IOException {
		int userChoice = 0;
		System.out.println("Wlecome to the Countries Maintenance Application!");
		String prompt = "\n" + "1- See the list of counries" + "\n" + "2- Add a country" + "\n" + "3- Exit" + "\n"
				+ "\nEnter menu number: ";

		CountriesTextFile countriesFile = new CountriesTextFile(filePath);
		countriesFile.ensureFileExists();

		while (userChoice != 3) {
			userChoice = Validator.getInt(scnr, prompt);
			if (userChoice == 1) {
				List<String> linesOfCountries = countriesFile.readFile();
				for (String countryInfo : linesOfCountries) {
					System.out.println(countryInfo);
				}
			} else if (userChoice == 2) {
				Country country = new Country();
				String countryName = Validator.getString(scnr, "Enter country: ");
				country.setName(countryName);
				double countryPop = Validator.getDouble(scnr, "Enter population: ");
				country.setPopulation(countryPop);
				countriesFile.appendToFile(country);
			}
		}
		System.out.println("\nBuh-bye");
	}/* End of run() */
}
