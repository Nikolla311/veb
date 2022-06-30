package vezbe.demo.dto;

import vezbe.demo.model.Tip_artikla;

public class ArtikalUpdateDto {

    protected Long id;
    protected String naziv;

    protected double cena;

    protected Tip_artikla tip_artikla;

    protected double kolicina;

    protected String opis;

    public ArtikalUpdateDto() {}

    public ArtikalUpdateDto(Long id, String naziv, double cena, Tip_artikla tip_artikla, double kolicina, String opis) {
        this.id = id;
        this.naziv = naziv;
        this.cena = cena;
        this.tip_artikla = tip_artikla;
        this.kolicina = kolicina;
        this.opis = opis;
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
}
