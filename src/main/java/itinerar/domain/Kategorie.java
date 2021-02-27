package itinerar.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "kategorie")
public class Kategorie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "nazev", nullable = false, unique = false)
    private String nazev;

    @NotNull
    @Column(name = "barva", nullable = false, unique = false)
    private String barva;

    @NotNull
    @Column(name = "ikona", nullable = false, unique = false)
    private String ikona;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String getBarva() {
        return barva;
    }

    public void setBarva(String barva) {
        this.barva = barva;
    }

    public String getIkona() {
        return ikona;
    }

    public void setIkona(String ikona) {
        this.ikona = ikona;
    }
}
