package co.aisaac.finances;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancialTransactionRepo extends CrudRepository<FinancialTransaction, Long> {
}
