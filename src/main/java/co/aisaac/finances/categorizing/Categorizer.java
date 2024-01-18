package co.aisaac.finances.categorizing;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 * If a String matches the categorizer, then it is categorized.
 */
@Getter
@Setter
@Entity
public class Categorizer {

	@Id
	@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
	private Long id;

	@Column(name = "phrase")
	private String phrase;

	@Column(name = "category")
	private String category;

	public boolean matches(String description) {
		return description.toUpperCase().contains(phrase.toUpperCase());
	}

}
