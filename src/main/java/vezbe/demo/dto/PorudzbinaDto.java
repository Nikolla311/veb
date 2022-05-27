package vezbe.demo.dto;

import vezbe.demo.model.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class PorudzbinaDto {

    private LocalDateTime vremePorudzbine;

    private Set<Stavka> stavke = new HashSet<>();

    private Kupac kupac;

    private Dostavljac dostavljac;

    private double Cena;

    private Restoran restoran;

    private Set<ArtikalPorudzbina> artikalporudzbina;


    public PorudzbinaDto(Porudzbina p){
        this.vremePorudzbine = p.getVreme_porudzbine();
        this.kupac = p.getKupac();
        this.dostavljac = p.getDostavljac();
        this.Cena = p.getCena();
        this.restoran = p.getRestoran();
        this.artikalporudzbina = new HashSet<>();
    }

    public LocalDateTime getVremePorudzbine() {
        return vremePorudzbine;
    }

    public void setVremePorudzbine(LocalDateTime vremePorudzbine) {
        this.vremePorudzbine = vremePorudzbine;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    public Dostavljac getDostavljac() {
        return dostavljac;
    }

    public void setDostavljac(Dostavljac dostavljac) {
        this.dostavljac = dostavljac;
    }

    public double getCena() {
        return Cena;
    }

    public void setCena(double cena) {
        Cena = cena;
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }

    public Set<ArtikalPorudzbina> getArtikalporudzbina() {
        return artikalporudzbina;
    }

    public void setArtikalporudzbina(Set<ArtikalPorudzbina> artikalporudzbina) {
        this.artikalporudzbina = artikalporudzbina;
    }
}
