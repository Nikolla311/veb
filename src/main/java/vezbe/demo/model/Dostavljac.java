package vezbe.demo.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.*;
import java.util.*;

@Entity
public class Dostavljac extends Korisnik implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //protected ArrayList<Porudzbina> porudzbine;



    @OneToMany(mappedBy = "dostavljac", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Porudzbina> porudzbine_dostavljaca = new HashSet<>();

    public Dostavljac() {
    }

    public Dostavljac(String korisnicko_ime, Pol pol, String lozinka, String ime, String prezime, Date datum_rodjenja) {
        super(korisnicko_ime, pol, lozinka, ime, prezime, datum_rodjenja, Uloga.DOSTAVLJAC);
        //setUloga(Uloga.DOSTAVLJAC);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Porudzbina> getPorudzbine_dostavljaca() {
        return porudzbine_dostavljaca;
    }

    public void setPorudzbine_dostavljaca(Set<Porudzbina> porudzbine_dostavljaca) {
        this.porudzbine_dostavljaca = porudzbine_dostavljaca;
    }
}
