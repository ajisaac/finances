package co.aisaac.finances.bills;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BillsController {

	@GetMapping("/bills")
	public String getBills() {
		return "bills/index";
	}
}
