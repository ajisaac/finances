package co.aisaac.finances;

import co.aisaac.finances.utils.importers.*;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
public class MainController {

	@GetMapping("/")
	public String homepage(Model model) throws IOException, CsvException {

		var abankTransactions = new ImportAcVeBankTransactions("data/a_bank.csv").run();
		var abankSavingsTransactions = new ImportAcVeBankTransactions("data/a_bank_savings.csv").run();
		var vbankTransactions = new ImportAcVeBankTransactions("data/v_bank.csv").run();

		var creditCardTransactions = new ImportCreditCardTransactions("data/credit_card.csv").run();

		var goldTransactions = new ImportGoldSilverTransactions("data/gold.csv").run();
		var silverTransactions = new ImportGoldSilverTransactions("data/silver1.csv").run();

		var mintTransactions = new ImportMintTransactions("data/transactions.csv").run();

		model.addAttribute("abankTransactions", abankTransactions);
		model.addAttribute("abankSavingsTransactions", abankSavingsTransactions);
		model.addAttribute("vbankTransactions", vbankTransactions);

		model.addAttribute("creditCardTransactions", creditCardTransactions);

		model.addAttribute("goldTransactions", goldTransactions);
		model.addAttribute("silverTransactions", silverTransactions);

		model.addAttribute("mintTransactions", mintTransactions);

		return "index";
	}

	public record TransactionPair(String original, String modified) {
	}

	@GetMapping("/minimalIndex")
	public String minimalIndex(Model model) throws IOException, CsvException {

		List<String> txs = new ArrayList<>();

		var abankTransactions = new ImportAcVeBankTransactions("data/a_bank.csv").run();
		List<String> add = abankTransactions.stream().map(AcVeTransaction::getDescription).toList();
		txs.addAll(add);

		var abankSavingsTransactions = new ImportAcVeBankTransactions("data/a_bank_savings.csv").run();
		add = abankSavingsTransactions.stream().map(AcVeTransaction::getDescription).toList();
		txs.addAll(add);

		var vbankTransactions = new ImportAcVeBankTransactions("data/v_bank.csv").run();
		add = vbankTransactions.stream().map(AcVeTransaction::getDescription).toList();
		txs.addAll(add);

		var creditCardTransactions = new ImportCreditCardTransactions("data/credit_card.csv").run();
		add = creditCardTransactions.stream().map(CreditCardTransaction::getName).toList();
		txs.addAll(add);

		var goldTransactions = new ImportGoldSilverTransactions("data/gold.csv").run();
		add = goldTransactions.stream().map(GoldSilverTransaction::getTransaction).toList();
		txs.addAll(add);

		var silverTransactions = new ImportGoldSilverTransactions("data/silver1.csv").run();
		add = silverTransactions.stream().map(GoldSilverTransaction::getTransaction).toList();
		txs.addAll(add);

//		var mintTransactions = new ImportMintTransactions("data/transactions.csv").run();
//		add = mintTransactions.stream().map(MintTransaction::getDescription).toList();
//		txs.addAll(add);

		DescriptionFilter filter = new DescriptionFilter();
		filter.add("POS");
		filter.add("SIGNATURE");
		filter.add("DEBIT CARD PURCHASE");

		List<TransactionPair> pairs = new ArrayList<>();
		for (var tx : txs) {
			pairs.add(new TransactionPair(tx, filter.filter(tx)));
		}

		List<Categorizer> categorizers = new ArrayList<>();

		addCategorizer(categorizers, "Apple", "APPLE");
		addCategorizer(categorizers, "Amazon", "AMAZON");
		addCategorizer(categorizers, "Amazon", "AMZN");
		addCategorizer(categorizers, "Movies", "PRIME");
		addCategorizer(categorizers, "Uber", "UBER");
		addCategorizer(categorizers, "Spotify", "SPOTIFY");
		addCategorizer(categorizers, "Gym", "PLANET FIT");
		addCategorizer(categorizers, "Target", "TARGET");
		addCategorizer(categorizers, "Transfer", "INTERNET TRANSFER");
		addCategorizer(categorizers, "Transfer", "XFER");
		addCategorizer(categorizers, "Transfer", "MONEYLINE");
		addCategorizer(categorizers, "Fee", "SERVICE CHARGE");
		addCategorizer(categorizers, "Coffee", "STARBUCKS");
		addCategorizer(categorizers, "Coffee", "COFFEE");
		addCategorizer(categorizers, "Groceries", "QFC");


		pairs = pairs.stream().filter(p -> {
					boolean matches = false;
					for (var c : categorizers) {
						if (c.matches(p.modified())) {
							matches = true;
						}
					}
					return !matches;
				})
				.sorted(Comparator.comparing(TransactionPair::modified))
				.toList();

		model.addAttribute("transactions", pairs);

		return "minimalIndex";
	}

	private void addCategorizer(List<Categorizer> categorizers, String category, String... phrases) {
		Categorizer categorizer = new Categorizer(category);
		for (var phrase : phrases) {
			categorizer.addPhrase(phrase);
		}
		categorizers.add(categorizer);
	}

	@GetMapping("/notes")
	public String notes() {
		return "notes";
	}
}
