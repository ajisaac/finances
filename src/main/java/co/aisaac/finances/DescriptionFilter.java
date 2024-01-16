package co.aisaac.finances;

import java.util.ArrayList;
import java.util.List;

public class DescriptionFilter {
	// Take a string, and run a filter of strings against it, removing portions of the string
	List<String> filters;

	public DescriptionFilter() {
		this.filters = new ArrayList<>();
	}

	public void addAll(List<String> filters) {
		this.filters.addAll(filters);
	}

	public void add(String filter) {
		this.filters.add(filter);
	}

	public String filter(String name) {
		for (String filter : filters) {
			name = name.replaceAll(filter, "");
		}
		name = name.replaceAll(" {2}", " ");

		// replace all numbers with blank
		name = name.replaceAll("[0-9]", "");

		// remove any non alpha characters
		name = name.replaceAll("[^a-zA-Z ]", " ");

		return name;
	}

}
