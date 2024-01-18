package co.aisaac.finances.imports;

import lombok.Getter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
public class GoldSilverTransaction {

	// Run Date, Action, Symbol, Security Description, Security Type, Quantity,Price ($),Commission ($),Fees ($),Accrued Interest ($),Amount ($),Settlement Date
	private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	LocalDate date;
	String settlementDate;
	String transaction;

	String symbol;
	String securityDescription;
	String securityType;
	String quantity;
	String price;
	String commission;
	String fees;
	String accruedInterest;

	Double amount;

	public GoldSilverTransaction(String[] line) {

		// run date
		String d = line[0].trim();
		this.date = LocalDate.parse(d, dateTimeFormatter); // todo which timezone are these transactions in?

		// action
		this.transaction = line[1];

		// symbol
		this.symbol = line[2];

		// security description
		this.securityDescription = line[3];

		// security type
		this.securityType = line[4];

		// Quantity
		this.quantity  = line[5];

		// Price ($),
		this.price = line[6];

		// Commission ($),
		this.commission = line[7];

		// Fees ($),
		this.fees = line[8];

		// Accrued Interest ($),
		this.accruedInterest = line[9];

		// Amount ($),
		this.amount = line[10].isEmpty() ? 0.0 : Double.parseDouble(line[10]);

		// Settlement Date
		this.settlementDate = line[11];

	}

	@Override
	public String toString() {
		return date.toString() + ", " + transaction + ", " + symbol + ", " + securityDescription + ", " + securityType + ", " + quantity + ", " + price + ", " + commission + ", " + fees + ", " + accruedInterest + ", " + amount + ", " + settlementDate;
	}
}
