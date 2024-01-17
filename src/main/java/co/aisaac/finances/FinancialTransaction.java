package co.aisaac.finances;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity(name = "financial_transaction")
public class FinancialTransaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "account_name")
	String accountName;
	@Column(name = "transaction_date")
	LocalDate date;
	@Column(name = "description")
	String description;
	@Column(name = "modified_description")
	String modifiedDescription;
	@Column(name = "debit")
	BigDecimal debit;
	@Column(name = "credit")
	BigDecimal credit;
	@Column(name = "status")
	String status;
	@Column(name = "category")
	String category;
	@Column(name = "type")
	String type;
	@Column(name = "location")
	String location;

}
