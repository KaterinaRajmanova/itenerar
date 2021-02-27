package itinerar.repository;

import io.micronaut.context.annotation.Executable;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import itinerar.domain.Itinerar;
import itinerar.domain.Polozka;

import java.util.List;

@Repository
public interface PolozkaRepository extends CrudRepository<Polozka,Long> {
    public List<Polozka> findByItinerarId (Long itinerarId);

    @Executable
    void delete(Itinerar itinerar, Long id);
}

