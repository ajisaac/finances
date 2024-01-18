package co.aisaac.finances.categorizing;

import co.aisaac.finances.transactions.FinancialTransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategorizingController {

	@Autowired
	FinancialTransactionRepo financialTransactionRepo;

	@GetMapping("/categories")
	public String categories(Model model) {
		var txs = financialTransactionRepo.findAll();

		model.addAttribute("transactions", txs);
		return "categories/index";
	}

}
