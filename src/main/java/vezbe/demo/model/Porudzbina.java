package vezbe.demo.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.*;
import java.time.*;
import java.util.*;

@Entity

public class Porudzbina implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UUID;
    /*@Column
    protected int UUID;*/

    //protected ArrayList<Artikal> poruceni_artikli; //korpa
    //@Column
    //protected Restoran restoran;
    @Column
    protected LocalDateTime vreme_porudzbine;
    @Column
    protected double cena;
    //@Column
    //protected Kupac kupac;
    @Enumerated(EnumType.STRING)
    @Column
    private Status status;

    @ManyToOne
    @JoinColumn(name = "kupac_id")
    protected Kupac kupac;

    @ManyToOne
    @JoinColumn(name = "restoran_id")
    protected Restoran restoran;

    @OneToMany(mappedBy = "porudzbina", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<ArtikalPorudzbina> artikalporudzbina = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "dostavljac_id")
    protected Dostavljac dostavljac;
    public Porudzbina() {

    }

    public Porudzbina(LocalDateTime vreme_porudzbine, double cena, Korisnik korisnik, Dostavljac dostavljac, Restoran restoran) {
        //this.UUID = UUID;
        //this.poruceni_artikli = new ArrayList<>();
        this.restoran = restoran;
        this.kupac = kupac;
        this.dostavljac = dostavljac;
        
        this.vreme_porudzbine = vreme_porudzbine;
        this.cena = cena;
        //this.kupac = kupac;
        this.status = Status.OBRADA;
    }


    /*public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }*/

    public Dostavljac getDostavljac() {
        return dostavljac;
    }

    public void setDostavljac(Dostavljac dostavljac) {
        this.dostavljac = dostavljac;
    }

    public void DodajUKorpu(){

    }
    public void IzbaciIzKorpe() {}

    /*public int getUUID() {
        return UUID;
    }*/
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    /*public void setUUID(int UUID) {
        this.UUID = UUID;
    }

    /*public ArrayList<Artikal> getPoruceni_artikli() {
        return poruceni_artikli;
    }*/

    /*public void setPoruceni_artikli(ArrayList<Artikal> poruceni_artikli) {
        this.poruceni_artikli = poruceni_artikli;
    }*/

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }

    public LocalDateTime getVreme_porudzbine() {
        return vreme_porudzbine;
    }

    public void setVreme_porudzbine(LocalDateTime vreme_porudzbine) {
        this.vreme_porudzbine = vreme_porudzbine;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }
}
