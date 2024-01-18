package co.aisaac.finances.transactions;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinancialTransactionRepo extends ListCrudRepository<FinancialTransaction, Long> {

	@Query("SELECT DISTINCT category FROM financial_transaction")
	List<String> findDistinctCategories();

}
