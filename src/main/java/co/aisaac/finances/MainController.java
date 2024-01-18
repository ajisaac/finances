package co.aisaac.finances;

import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class MainController {

	@GetMapping("/")
	public String homepage(Model model) throws IOException, CsvException {
		return "index";
	}

	// todo crypto
	// todo amazon
	// todo, improve the input format

	// want a map of categories, then on a page we can see what gets categorized how
	// want a page where we match previous mint transactions with current transactions, to easily categorize
	// want to put all our transactions in the database, create a common interface, go ahead and categorize everything


	@GetMapping("/notes")
	public String notes() {
		return "notes";
	}
}
