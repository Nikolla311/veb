package vezbe.demo.dto;

import vezbe.demo.model.*;

import java.util.*;

public class DostavljacDto {

    protected String username;
    protected String lozinka;
    protected String ime;
    protected String prezime;
    protected Pol pol;
    protected Date datum_rodjenja;
    protected Uloga uloga;

    public DostavljacDto() {
    }
    public DostavljacDto(Dostavljac dostavljac) {
        this.username = dostavljac.getUsername();
        this.lozinka = dostavljac.getLozinka();
        this.ime = dostavljac.getIme();
        this.prezime = dostavljac.getPrezime();
        this.pol = dostavljac.getPol();
        this.datum_rodjenja = dostavljac.getDatum_rodjenja();
        this.uloga = Uloga.DOSTAVLJAC;
    }

    public DostavljacDto(String username, String lozinka, String ime, String prezime, Pol pol, Date datum_rodjenja) {
        this.username = username;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.pol = pol;
        this.datum_rodjenja = datum_rodjenja;
        this.uloga = Uloga.DOSTAVLJAC;
    }
    //protected Uloga uloga;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Pol getPol() {
        return pol;
    }

    public void setPol(Pol pol) {
        this.pol = pol;
    }

    public Date getDatum_rodjenja() {
        return datum_rodjenja;
    }

    public void setDatum_rodjenja(Date datum_rodjenja) {
        this.datum_rodjenja = datum_rodjenja;
    }

    public Uloga getUloga() {
        return uloga;
    }

    public void setUloga(Uloga uloga) {
        this.uloga = uloga;
    }
}
