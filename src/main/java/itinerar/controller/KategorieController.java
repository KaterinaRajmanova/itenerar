package itinerar.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import itinerar.domain.Itinerar;
import itinerar.domain.Kategorie;

@Controller
public class KategorieController {

    @Get("/kategorie")
    public Kategorie test(){
       Kategorie kategorie = new Kategorie();
        kategorie.setId(4923l);
        kategorie.setBarva("cervena");
        return kategorie;

    }
}