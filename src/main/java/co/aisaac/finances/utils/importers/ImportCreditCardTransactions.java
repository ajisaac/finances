package co.aisaac.finances.utils.importers;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ImportCreditCardTransactions {

	final private String path;

	public ImportCreditCardTransactions(String path) {
		this.path = path;
	}

	public List<CreditCardTransaction> run() throws IOException, CsvException {
		File file = new File(path);
		List<CreditCardTransaction> transactions = new ArrayList<>();
		try (Reader reader = Files.newBufferedReader(file.toPath());
			 CSVReader csv = new CSVReader(reader)) {
			csv.skip(1);
			List<String[]> lines = csv.readAll();
			for (String[] line : lines) {
				transactions.add(new CreditCardTransaction(line));
			}
		}
		return transactions;
	}
}

