package co.aisaac.finances.categorizing;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorizerRepo extends ListCrudRepository<Categorizer, Long> {
}
