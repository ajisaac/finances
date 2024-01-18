package co.aisaac.finances.categorizing;

import co.aisaac.finances.transactions.FinancialTransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService {

	@Autowired
	private FinancialTransactionRepo financialTransactionRepo;

	@Autowired
	private CategorizerRepo categorizerRepo;

	/**
	 * Fetch all the categories associated with any transactions in the database.
	 */
	public List<String> fetchCategories() {
		return financialTransactionRepo.findDistinctCategories();
	}

	/**
	 * Fetch all the categorizers in the database.
	 */
	public List<Categorizer> fetchCategorizers() {
		return categorizerRepo.findAll();
	}
}
