package co.aisaac.finances.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CreditCardTransaction {

	private static final DateTimeFormatter mintTransactionFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDate date;
	String transaction, name, memo;
	Double amount;

	public CreditCardTransaction(String[] line) {

		// "Date","Transaction","Name","Memo","Amount"
		// memo = "number", "merchant", null, null, null
		String d = line[0];
		this.date = LocalDate.parse(d, mintTransactionFormatter);
		this.transaction= line[1];
		this.name = line[2];
		this.memo = line[3];
		this.amount = Double.parseDouble(line[4]);
	}

	@Override
	public String toString(){
		return date + ", " + transaction + " " + name + " " + memo + " " + amount.toString();

	}
}
