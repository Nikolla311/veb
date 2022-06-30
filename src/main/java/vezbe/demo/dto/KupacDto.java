package vezbe.demo.dto;

import vezbe.demo.model.*;

import java.util.*;

public class KupacDto {

    protected String username;
    protected String lozinka;
    protected String ime;
    protected String prezime;
    protected Pol pol;
    protected Date datum_rodjenja;

    public KupacDto() {
    }
    public KupacDto(Kupac kupac) {
        this.username = kupac.getUsername();
        this.lozinka = kupac.getLozinka();
        this.ime = kupac.getIme();
        this.prezime = kupac.getPrezime();
        this.pol = kupac.getPol();
        this.datum_rodjenja = kupac.getDatum_rodjenja();
    }

    public KupacDto(String username, String lozinka, String ime, String prezime, Pol pol, Date datum_rodjenja) {
        this.username = username;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.pol = pol;
        this.datum_rodjenja = datum_rodjenja;
    }


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

}
