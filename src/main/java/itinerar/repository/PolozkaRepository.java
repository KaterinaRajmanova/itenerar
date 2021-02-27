package itinerar.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import itinerar.domain.Polozka;

@Repository
public interface PolozkaRepository extends CrudRepository<Polozka,Long> {
}
