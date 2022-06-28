package vezbe.demo.dto;

import vezbe.demo.model.*;

import javax.persistence.Lob;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ArtikalDto {
    private Long id;
    @NotEmpty
    protected String naziv;
    @NotNull
    protected double cena;
    @NotNull
    protected Tip_artikla tip_artikla;

    protected double kolicina;
    protected String opis;
    //protected Restoran restoran;

    //private String photos;

    public ArtikalDto() {

    }

    public ArtikalDto(Long id, String naziv, double cena, double kolicina, Tip_artikla tip_artikla, String opis) {
        this.id = id;
        this.naziv = naziv;
        this.cena = cena;
        this.tip_artikla = tip_artikla;
        this.kolicina = kolicina;
        this.opis = opis;
    }
    public ArtikalDto(Long id, String naziv, double cena, Tip_artikla tip_artikla) {
        this.id = id;
        this.naziv = naziv;
        this.cena = cena;
        this.tip_artikla = tip_artikla;
        //this.kolicina = kolicina;
        //this.opis = opis;
    }
    public ArtikalDto(Artikal artikal) {
        this.id = artikal.getId();
        this.naziv = artikal.getNaziv();
        this.cena = artikal.getCena();
        this.kolicina = artikal.getKolicina();
        this.tip_artikla = artikal.getTip_artikla();
        this.opis = artikal.getOpis();
        //this.photos = artikal.getPhotos();
        //this.restoran = artikal.getRestoran();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Tip_artikla getTip_artikla() {
        return tip_artikla;
    }

    public void setTip_artikla(Tip_artikla tip_artikla) {
        this.tip_artikla = tip_artikla;
    }

    public double getKolicina() {
        return kolicina;
    }

    public void setKolicina(double kolicina) {
        this.kolicina = kolicina;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

   /* public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }*/
}
