package co.aisaac.finances.utils.importers;

import lombok.Getter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
public class AcVeTransaction {

	private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDate date;
	String accountNumber;
	String postDate;
	String check;
	String description;
	String debit;
	String credit;
	String status;
	String balance;

	public AcVeTransaction(String[] line) {

		// Account Number,Post Date,Check,Description,Debit,Credit,Status,Balance
		this.accountNumber = line[0];
		this.postDate = line[1];
		this.check = line[2];
		this.description = line[3];
		this.debit = line[4];
		this.credit = line[5];
		this.status = line[6];
		this.balance = line[7];

	}

	@Override
	public String toString() {
		return accountNumber + ", " + postDate + ", " + check + ", " + description + ", " + debit + ", " + credit + ", " + status + ", " + balance;
	}
}
