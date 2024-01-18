package co.aisaac.finances.imports;

import co.aisaac.finances.transactions.FinancialTransaction;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ImportsConverter {

	List<FinancialTransaction> addGoldSilverTransactions(List<GoldSilverTransaction> transactions, String name) {
		List<FinancialTransaction> financialTransactions = new ArrayList<>();
		for (var tx : transactions) {
			FinancialTransaction ft = new FinancialTransaction();
			ft.setAccountName(name);
			ft.setDate(tx.getDate());
			ft.setDescription(tx.getTransaction());

			if (tx.getAmount() > 0) {
				ft.setCredit(BigDecimal.valueOf(tx.getAmount()));
			} else {
				ft.setDebit(BigDecimal.valueOf(Math.abs(tx.getAmount())));
			}

			financialTransactions.add(ft);
		}
		return financialTransactions;
	}

	List<FinancialTransaction> addCreditCardTransactions(List<CreditCardTransaction> creditCardTransactions, String name) {
		List<FinancialTransaction> transactions = new ArrayList<>();
		for (var tx : creditCardTransactions) {
			FinancialTransaction ft = new FinancialTransaction();
			ft.setAccountName(name);
			ft.setDate(tx.getDate());
			ft.setDescription(tx.getName());
			if (tx.getAmount() > 0) {
				if (!tx.getTransaction().equals("CREDIT"))
					throw new IllegalStateException("Expected CREDIT, got " + tx.getTransaction());
				ft.setCredit(BigDecimal.valueOf(tx.getAmount()));
			} else {
				if (!tx.getTransaction().equals("DEBIT"))
					throw new IllegalStateException("Expected DEBIT, got " + tx.getTransaction());
				ft.setDebit(BigDecimal.valueOf(Math.abs(tx.getAmount())));
			}
			transactions.add(ft);

			// todo grab that memo at some point
		}
		return transactions;
	}

	List<FinancialTransaction> addAcvTransactions(List<AcVeTransaction> abankTransactions, String name) {
		List<FinancialTransaction> transactions = new ArrayList<>();
		for (var tx : abankTransactions) {
			FinancialTransaction ft = new FinancialTransaction();
			ft.setAccountName(name);
			ft.setDate(tx.getDate());
			ft.setDescription(tx.getDescription());

			if (StringUtils.isNotBlank(tx.getDebit())) {
				try {
					BigDecimal debit = new BigDecimal(tx.getDebit());
					ft.setDebit(debit);
				} catch (NumberFormatException ex) {
					System.out.println("Could not parse debit: " + tx.getDebit());
				}
			}

			if (StringUtils.isNotBlank(tx.getCredit())) {
				try {
					BigDecimal credit = new BigDecimal(tx.getCredit());
					ft.setCredit(credit);
				} catch (NumberFormatException ex) {
					System.out.println("Could not parse credit: " + tx.getCredit());
				}
			}

			ft.setStatus(tx.getStatus());
			transactions.add(ft);
		}
		return transactions;
	}
}
