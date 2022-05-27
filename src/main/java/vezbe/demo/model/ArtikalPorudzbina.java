package vezbe.demo.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.*;

@Entity
public class ArtikalPorudzbina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    protected int kolicina;

    @ManyToOne
    @JoinColumn(name = "porudzbina_id")
    protected Porudzbina porudzbina;

    @ManyToOne
    //@JoinColumn(name = "dostavljac_id")
    protected Artikal artikal;

    public ArtikalPorudzbina() {

    }

    public ArtikalPorudzbina(int kolicina, Porudzbina porudzbina, Artikal artikal) {
        this.kolicina = kolicina;
        this.porudzbina = porudzbina;
        this.artikal = artikal;
        // porudzbina.getRestoran() = artikal.restoran;
    }
}

