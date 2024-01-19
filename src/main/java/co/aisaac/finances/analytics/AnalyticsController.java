package co.aisaac.finances.analytics;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnalyticsController {

	@GetMapping("/analytics")
	public String analytics() {
		return "analytics/index";
	}

	/*
	features
	Main page, show list of accounts on right, click on list to see details for that account
	Want to see total cash in all accounts
	Total debt and loans
	Any crypto or stock purchases
	Can click on a transaction to see details, or maybe hover

	Set some financial goals
	Spending by category over month or time period


	 */
}
