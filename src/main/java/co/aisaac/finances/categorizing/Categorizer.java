package co.aisaac.finances.categorizing;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * If a String matches the categorizer, then it is categorized.
 */
public class Categorizer {

	private List<String> phrases = new ArrayList<>();
	private String category;

	public Categorizer(String category) {
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

	public void addPhrase(String phrase) {
		this.phrases.add(phrase.toUpperCase(Locale.ROOT));
	}

	public boolean matches(String description) {
		String upper = description.toUpperCase();
		for (String phrase : phrases) {
			if (!upper.contains(phrase)) {
				return false;
			}
		}
		return true;
	}

}
