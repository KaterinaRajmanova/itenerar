package itinerar.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import itinerar.domain.Polozka;

import java.util.List;

@Repository
public interface PolozkaRepository extends CrudRepository<Polozka,Long> {
    public List<Polozka> findByItinerarId (Long itinerarId);
}

