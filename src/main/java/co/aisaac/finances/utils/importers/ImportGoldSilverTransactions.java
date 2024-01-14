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

	final private String path;

	public ImportGoldSilverTransactions(String path) {
		this.path = path;
	}

	public List<GoldSilverTransaction> run() throws IOException, CsvException {
		File file = new File(path);
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
