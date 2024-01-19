package co.aisaac.finances.investments;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InvestmentsController {

	@GetMapping("/investments")
	public String getInvestments() {
		return "investments/index";
	}

}
