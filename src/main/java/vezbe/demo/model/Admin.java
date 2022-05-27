package vezbe.demo.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.*;
import java.util.*;

@Entity
public class Admin extends Korisnik implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //protected ArrayList<Porudzbina> porudzbine;





    public Admin() {
    }

    public Admin(String korisnicko_ime, Pol pol, String lozinka, String ime, String prezime, Date datum_rodjenja) {
        super(korisnicko_ime, pol, lozinka, ime, prezime, datum_rodjenja, Uloga.ADMIN);
        //setUloga(Uloga.DOSTAVLJAC);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
