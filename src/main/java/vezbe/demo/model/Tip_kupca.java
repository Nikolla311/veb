package vezbe.demo.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.*;
import java.util.*;

//enum Ime {ZLATNI, SREBRNI, BRONZANI};
@Entity
public class Tip_kupca implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column
    protected Ime_tip_kupca ime;

    protected int popust;
    protected int trazeni_br_bodova;

    @OneToMany(mappedBy = "tip_kupca", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Kupac> kupci = new HashSet<>();

    public Tip_kupca() {
    }

    public Tip_kupca(Ime_tip_kupca ime, int popust, int trazeni_br_bodova) {
        this.ime = ime;
        this.popust = popust;
        this.trazeni_br_bodova = trazeni_br_bodova;
    }

    public int getPopust() {
        return popust;
    }

    public void setPopust(int popust) {
        this.popust = popust;
    }

    public int getTrazeni_br_bodova() {
        return trazeni_br_bodova;
    }

    public void setTrazeni_br_bodova(int trazeni_br_bodova) {
        this.trazeni_br_bodova = trazeni_br_bodova;
    }

    public Ime_tip_kupca getIme() {
        return ime;
    }

    public void setIme(Ime_tip_kupca ime) {
        this.ime = ime;
    }
}
