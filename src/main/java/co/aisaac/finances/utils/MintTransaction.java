package co.aisaac.finances.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MintTransaction {
	// "Date","Description","Original Description","Amount","Transaction Type","Category","Account Name","Labels","Notes"
	private static final DateTimeFormatter mintTransactionFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
	LocalDate date;
	String description, originalDescription, transactionType, category, accountName;
	Double amount;

	public MintTransaction(String[] line) {

		// "Date","Description","Original Description","Amount","Transaction Type","Category","Account Name","Labels","Notes"
		String d = line[0].replaceAll("\"", "");
		this.date = LocalDate.parse(d, mintTransactionFormatter);
		this.description = line[1];
		this.originalDescription = line[2];
		this.amount = Double.parseDouble(line[3]);
		this.transactionType = line[4];
		this.category = line[5];
		this.accountName = line[6];
	}
}
