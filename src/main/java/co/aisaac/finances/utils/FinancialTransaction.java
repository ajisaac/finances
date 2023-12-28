package co.aisaac.finances.utils;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "financial_transaction")
public class FinancialTransaction {
	@Id
	private Long id;

}
