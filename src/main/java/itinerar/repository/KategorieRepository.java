package itinerar.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import itinerar.domain.Kategorie;

@Repository
public interface KategorieRepository extends CrudRepository<Kategorie,Long> {
}
