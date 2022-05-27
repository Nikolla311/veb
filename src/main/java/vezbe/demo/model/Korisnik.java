package vezbe.demo.model;

import javax.persistence.*;
import java.io.*;
import java.util.*;

@Entity
public class Korisnik implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    protected String username;

    @Column
    protected String lozinka;

    @Column
    protected String ime;

    @Column
    protected String prezime;

    @Enumerated(EnumType.STRING)
    @Column
    protected Pol pol;

    @Temporal(TemporalType.DATE)
    @Column
    protected Date datum_rodjenja;
    //@Column
    //protected Date datum_rodjenja;
    @Enumerated(EnumType.STRING)
    @Column
    protected Uloga uloga;

    //@Column
    //protected boolean status_prijave;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pol getPol() {
        return pol;
    }

    public Korisnik() {
    }

    public Korisnik(String username, Pol pol, String lozinka, String ime, String prezime, Date datum_rodjenja, Uloga uloga) {
        this.username = username;
        this.lozinka = lozinka;
        this.pol = pol;
        this.ime = ime;
        this.prezime = prezime;
        this.datum_rodjenja = datum_rodjenja;
        this.uloga = uloga;
    }
    /*public boolean isStatus_prijave() {
        return status_prijave;
    }*/

    /*public void setStatus_prijave(boolean status_prijave) {
        this.status_prijave = status_prijave;
    }*/
    public Pol isPol() {
        return pol;
    }

    public void setPol(Pol pol) {
        this.pol = pol;
    }

    public Uloga getUloga() {
        return uloga;
    }

    public void setUloga(Uloga uloga) {
        this.uloga = uloga;
    }

    /*public String getKorisnicko_ime() {
        return korisnicko_ime;
    }

    public void setKorisnicko_ime(String korisnicko_ime) {
        this.korisnicko_ime = korisnicko_ime;
    }*/

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

    public Date getDatum_rodjenja() {
        return datum_rodjenja;
    }

    public void setDatum_rodjenja(Date datum_rodjenja) {
        this.datum_rodjenja = datum_rodjenja;
    }
}
