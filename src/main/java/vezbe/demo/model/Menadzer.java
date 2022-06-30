package vezbe.demo.model;

import com.fasterxml.jackson.annotation.*;
import org.springframework.beans.factory.annotation.*;

import javax.persistence.*;
import java.io.*;
import java.util.*;

@Entity
public class Menadzer extends Korisnik implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /*@OneToMany(mappedBy = "menadzer", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Restoran> restorani_menadzera = new HashSet<>();*/
   // @Autowired
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restoran_id")
    protected Restoran restoran;


    public Menadzer() {
    }

    public Menadzer(String username, Pol pol, String lozinka, String ime, String prezime, Date datum_rodjenja, Restoran restoran) {
        super(username, pol, lozinka, ime, prezime, datum_rodjenja, Uloga.MENADZER);
        this.restoran = restoran;
        //setUloga(Uloga.MENADZER);
    }
    public Menadzer(String username, Pol pol, String lozinka, String ime, String prezime, Date datum_rodjenja) {
        super(username, pol, lozinka, ime, prezime, datum_rodjenja, Uloga.MENADZER);
        //this.restoran = restoran;
        //setUloga(Uloga.MENADZER);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }
}
