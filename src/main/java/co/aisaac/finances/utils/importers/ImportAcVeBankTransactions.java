package co.aisaac.finances.utils.importers;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ImportAcVeBankTransactions {

	public static void main(String[] args) throws IOException, CsvException {

		File file = new File("data/a_bank.csv");
		List<AcVeTransaction> transactions = parseTransactions(file);
		transactions.forEach(System.out::println);

		file = new File("data/a_bank_savings.csv");
		transactions = parseTransactions(file);
		transactions.forEach(System.out::println);

		file = new File("data/v_bank.csv");
		transactions = parseTransactions(file);
		transactions.forEach(System.out::println);

	}

	private static List<AcVeTransaction> parseTransactions(File file) throws IOException, CsvException {
		List<AcVeTransaction> transactions = new ArrayList<>();
		try (Reader reader = Files.newBufferedReader(file.toPath());
			 CSVReader csv = new CSVReader(reader)) {
			csv.skip(1);
			List<String[]> lines = csv.readAll();
			for (String[] line : lines) {
				transactions.add(new AcVeTransaction(line));
			}
		}
		return transactions;
	}
}
