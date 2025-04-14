import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Controller {

	private static ArrayList<Product> products = new ArrayList<>();

	public static void addTariffs(String filePath, String updatedFilePath) throws FileNotFoundException {
		readDataFile(filePath);
		applyTariffs();
		writeProducts(updatedFilePath);
	}

	private static void readDataFile(String filePath) throws FileNotFoundException {
		try (
		Scanner reader = new Scanner(new FileInputStream(filePath))) {
			String[] line;
			while (reader.hasNextLine()) {
				String words = reader.nextLine();
				System.out.println(words);
				line = words.split(",");

				products.add(new Product(line[0], line[1], line[2], Double.parseDouble(line[3])));
			}
		} 
		Collections.sort(products);

	}

	private static void applyTariffs() {
		for (Product product : products) {
			String country = product.getCountry();
			String category = product.getCategory();
			double originalPrice = product.getPrice();
			double newPrice = originalPrice;

			switch (country) {
			case "China":
				newPrice = originalPrice * 1.25;
				break;
			case "USA":
				if (category.equalsIgnoreCase("Electronics"))
					newPrice = originalPrice * 1.10;
				break;
			case "Japan":
				if (category.equalsIgnoreCase("Automobiles"))
					newPrice = originalPrice * 1.15;
				break;
			case "India":
				if (category.equalsIgnoreCase("Agriculture"))
					newPrice = originalPrice * 1.05;
				break;
			case "South Korea":
				if (category.equalsIgnoreCase("Electronics"))
					newPrice = originalPrice * 1.08;
				break;
			case "Saudi Arabia":
				if (category.equalsIgnoreCase("Energy"))
					newPrice = originalPrice * 1.12;
				break;
			case "Germany":
				if (category.equalsIgnoreCase("Manufacturing"))
					newPrice = originalPrice * 1.06;
				break;
			case "Bangladesh":
				if (category.equalsIgnoreCase("Textile"))
					newPrice = originalPrice * 1.04;
				break;
			case "Brazil":
				if (category.equalsIgnoreCase("Agriculture"))
					newPrice = originalPrice * 1.09;
				break;
			}
			product.setPrice(newPrice);
		}
	}

	private static void writeProducts(String filePath) throws FileNotFoundException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			for (Product product : products) {
				writer.write(product.toString());
				writer.newLine();
			}
		} catch (IOException e) {
			System.out.println("Error writing to file: " + filePath);
		}
	}

}