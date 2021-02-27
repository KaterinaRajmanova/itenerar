package itinerar.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@Entity
@Table(name = "polozka")
public class Polozka {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "popisek", nullable = false)
    private String popisek;

    @NotNull
    @Column(name = "datum", nullable = false)
    private LocalTime datum;

    @NotNull
    @Column(name = "cas_od", nullable = false)
    private LocalTime casOd;

    @NotNull
    @Column(name = "cas_do", nullable = false)
    private LocalTime casDo;

    @Column (name = "odkaz", nullable = true)
    private String odkaz;

    @ManyToOne
    @JoinColumn(name = "kategorie_id", nullable = false)
    private Kategorie kategorie;

    @ManyToOne
    @JoinColumn(name = "itinerar_id", nullable = false)
    private Itinerar itinerar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPopisek() {
        return popisek;
    }

    public void setPopisek(String popisek) {
        this.popisek = popisek;
    }

    public LocalTime getDatum() {
        return datum;
    }

    public void setDatum(LocalTime datum) {
        this.datum = datum;
    }

    public LocalTime getCasOd() {
        return casOd;
    }

    public void setCasOd(LocalTime casOd) {
        this.casOd = casOd;
    }

    public LocalTime getCasDo() {
        return casDo;
    }

    public void setCasDo(LocalTime casDo) {
        this.casDo = casDo;
    }

    public String getOdkaz() {
        return odkaz;
    }

    public void setOdkaz(String odkaz) {
        this.odkaz = odkaz;
    }

    public Kategorie getKategorie() {
        return kategorie;
    }

    public void setKategorie(Kategorie kategorie) {
        this.kategorie = kategorie;
    }

    public Itinerar getItinerar() {
        return itinerar;
    }

    public void setItinerar(Itinerar itinerar) {
        this.itinerar = itinerar;
    }
}
