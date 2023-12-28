package co.aisaac.finances.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MintTransaction {
	// "Date","Description","Original Description","Amount","Transaction Type","Category","Account Name","Labels","Notes"
	private static final DateTimeFormatter mintTransactionFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
	LocalDate date;
	String description, originalDescription, amount, transactionType, category, accountName, labels, notes;

	public MintTransaction(String line) {
		String[] fields = line.split(",");

		String d = fields[0].replaceAll("\"", "");
		this.date = LocalDate.parse(d, mintTransactionFormatter);
		this.description = fields[1];
		this.originalDescription = fields[2];
		this.amount = fields[3];
		this.transactionType = fields[4];
		this.category = fields[5];
		this.accountName = fields[6];
		this.labels = fields[7];
		this.notes = fields[8];
	}

	public String toString() {
//		return String.format("%s\t %s\t %s\t %s\t %s\t %s\t %s\t %s ", date, transactionType, category, accountName, description, amount, labels, notes);
//		return date.toString();
		return transactionType;
	}
}
