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
        return polozkaRepository.findByItinerarId(id);
    }
    //Seznam kategorii
    @Get("/kategorie")
    public List <Kategorie> kategorieList (){
        return (List<Kategorie>) kategorieRepository.findAll();
    }

    //prejmenova itinerare
    @Put ("/itinerar/{id}")
    public Itinerar update(Long id, Itinerar itinerar){
        return itinerarRepository.update(itinerar);
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
        polozka.setItinerar(itinerar.get());
        return polozkaRepository.save(polozka);
    }

    //smazani polozky
    @Delete ("/itinerar/{idItinerar}/polozka/{idPolozka}")
    public void deletePolozka (Long idItinerar, Long idPolozka){
        Optional<Itinerar> itinerar = itinerarRepository.findById(idItinerar);
        itinerarRepository.deleteByItinerarIdAndPolozkaId(idItinerar,idPolozka );
    }

    //editace polozky
    @Put ("/itinerar/{idItinirar}/polozka/{idPolozka}")
    public void editPolozka (Long idItinerar, Long idPolozka, Polozka polozka){
        Optional<Itinerar> itinerar = itinerarRepository.findById(idItinerar);
        polozka.setItinerar(itinerar.get());
        polozkaRepository.update(polozka);

    }


}
