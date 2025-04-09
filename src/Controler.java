import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Controler {

	private static ArrayList<Product> products = new ArrayList<>();

	public static void addtarrifs(String filePath) throws FileNotFoundException {
		readDataFile(filePath);
		applyTariffs();
		writeProducts(filePath);
	}

	private static void readDataFile(String filePath) throws FileNotFoundException {
		Scanner reader = null;
		try {
			reader = new Scanner(new FileInputStream(filePath));
			String[] line = new String[4];
			while (reader.hasNextLine()) {
				line = reader.nextLine().split(",");

				products.add(new Product(line[0], line[1], line[2], Double.parseDouble(line[3])));
			}
		} catch (FileNotFoundException e) {
			System.out.println("TradeData.txt was not found");
			System.exit(0);

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

	private static void writeProducts(String filePath) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
			for (Product product : products) {
				writer.println(product.toString());
			}
		} catch (IOException e) {
			System.out.println("Error writing to file: " + filePath);
		}
	}

}