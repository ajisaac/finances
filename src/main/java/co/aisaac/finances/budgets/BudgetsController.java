package co.aisaac.finances.budgets;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BudgetsController {

	@GetMapping("/budgets")
	public String getBudgets() {
		return "budgets/index";
	}

}
