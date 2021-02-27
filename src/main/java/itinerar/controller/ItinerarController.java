package itinerar.controller;

import io.micronaut.http.annotation.*;
import itinerar.domain.Itinerar;
import itinerar.domain.Kategorie;
import itinerar.domain.Polozka;
import itinerar.repository.ItinerarRepository;
import itinerar.repository.KategorieRepository;
import itinerar.repository.PolozkaRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Controller
public class ItinerarController {

    private final ItinerarRepository itinerarRepository;
    private final PolozkaRepository polozkaRepository;
    private final KategorieRepository kategorieRepository;

    @Inject
    public ItinerarController(ItinerarRepository itinerarRepository,PolozkaRepository polozkaRepository, KategorieRepository kategorieRepository ) {
        this.itinerarRepository = itinerarRepository;
        this.polozkaRepository = polozkaRepository;
        this.kategorieRepository = kategorieRepository;
    }

    //seznam itineraru
    @Get("/itinerar")
    public List<Itinerar> itinerarList(){
        return (List<Itinerar>) itinerarRepository.findAll();
    }

    //zalozeni noveho itinerare
    @Post("/itinerar")
    public Itinerar save(Itinerar itinerar){
        return itinerarRepository.save(itinerar);
    }

    //seznam polozek itinerare
    @Get("/itinerar/{id}/polozka")
    public List<Polozka> polozkaList (Long id){
        Optional<Itinerar> itinerar = itinerarRepository.findById(id);
        itinerar.get().
        return (List<Polozka>) polozkaRepository.findAll();
    }
    //Seznam kategorii
    @Get("/kategorie")
    public List <Kategorie> kategorieList (){
        return (List<Kategorie>) kategorieRepository.findAll();
    }

    //prejmenova itinerare
    @Put ("/itinerar/{id}")
    public void rename(Long id, String novyNazev){
        Optional<Itinerar> itinerar = itinerarRepository.findById(id);
        itinerar.get().setNazev(novyNazev);
    }

    //archivace itinerare
    @Delete ("/itinerar/{id}")
    public void delete (Long id){
        itinerarRepository.deleteById(id);
    }

    //pridani polozky
    @Post("/itinerar/{id}/polozka")
    public Polozka save(Polozka polozka, Long id){
        Optional<Itinerar> itinerar = itinerarRepository.findById(id);

        return polozkaRepository.save(polozka);
    }

    //smazani polozky
    @Delete ("/itinerar/{id}/polozka/{id}")
    public void deletePolozka (Long id){
        Optional<Itinerar> itinerar = itinerarRepository.findById(id);

    }

    //editace polozky
    @Put ("/itinerar/{id}/polozka/{id}")
    public void editPolozka (Long id){
        Optional<Itinerar> itinerar = itinerarRepository.findById(id);

    }


}
