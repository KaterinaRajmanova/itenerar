package itinerar.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import itinerar.domain.Itinerar;

@Repository
public interface ItinerarRepository extends CrudRepository<Itinerar,Long> {

}
