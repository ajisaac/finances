package co.aisaac.finances.transactions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TransactionsController {
	@GetMapping("/transactions")
	public String getTransactions() {
		return "transactions/index";
	}
}
