package co.aisaac.finances;

import co.aisaac.finances.utils.importers.*;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
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

	@GetMapping("/notes")
	public String notes() {
		return "notes";
	}
}
