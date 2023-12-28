package co.aisaac.finances.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ImportMintTransactions {
	public static void main(String[] args) throws IOException {
		File file = new File("data/transactions.csv");
		// "Date","Description","Original Description","Amount","Transaction Type","Category","Account Name","Labels","Notes"
		List<String> lines = Files.readAllLines(file.toPath());
		int i = 0;
		for (String line : lines) {
			if (i == 0) {
				i++;
				continue;
			}

			MintTransaction mintTransaction = new MintTransaction(line);
			System.out.println(mintTransaction);
		}
	}
}
