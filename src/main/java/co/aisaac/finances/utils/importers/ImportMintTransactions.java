package co.aisaac.finances.utils.importers;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ImportMintTransactions {

	public static void main(String[] args) throws IOException, CsvException {

		List<MintTransaction> transactions = parseTransactions();
		transactions.forEach(System.out::println);

	}

	private static List<MintTransaction> parseTransactions() throws IOException, CsvException {
		File file = new File("data/transactions.csv");
		List<MintTransaction> transactions = new ArrayList<>();
		try (Reader reader = Files.newBufferedReader(file.toPath());
			 CSVReader csv = new CSVReader(reader)) {
			csv.skip(1);
			List<String[]> lines = csv.readAll();
			for (String[] line : lines) {
				transactions.add(new MintTransaction(line));
			}
		}
		return transactions;
	}
}
