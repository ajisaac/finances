package co.aisaac.finances.goals;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GoalsController {

	@GetMapping("/goals")
	public String getGoals() {
		return "goals/index";
	}


}
