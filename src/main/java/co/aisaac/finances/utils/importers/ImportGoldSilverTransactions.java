package co.aisaac.finances.utils.importers;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ImportGoldSilverTransactions {

	public static void main(String[] args) throws IOException, CsvException {

//		File file = new File("data/silver1.csv");
//		List<GoldSilverTransaction> silverTransactions = parseTransactions(file);
//		silverTransactions.forEach(System.out::println);
//
		File file = new File("data/gold.csv");
		List<GoldSilverTransaction> goldTransactions = parseTransactions(file);
		goldTransactions.forEach(System.out::println);
	}

	private static List<GoldSilverTransaction> parseTransactions(File file) throws IOException, CsvException {
		List<GoldSilverTransaction> transactions = new ArrayList<>();
		try (Reader reader = Files.newBufferedReader(file.toPath());
			 CSVReader csv = new CSVReader(reader)) {
			csv.skip(1);
			List<String[]> lines = csv.readAll();
			for (String[] line : lines) {
				transactions.add(new GoldSilverTransaction(line));
			}
		}
		return transactions;
	}
}
