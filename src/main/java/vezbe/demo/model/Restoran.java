package vezbe.demo.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.*;
import java.util.*;

@Entity
public class Restoran implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    protected String nazivRestorana;
    @Column
    protected String tipRestorana;

    @Enumerated(EnumType.STRING)
    @Column
    private Status_restorana status_restorana;


    @OneToMany(mappedBy = "restoran", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Artikal> artikli = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "lokacija_id")
    private Lokacija lokacija;

    @OneToOne(mappedBy = "restoran", fetch = FetchType.LAZY)
    @JsonIgnore
    protected Menadzer menadzer;

    @OneToMany(mappedBy = "restoran", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Komentar> komentari = new HashSet<>();

    public Restoran() {
    }

    public Restoran(String nazivRestorana, String tipRestorana, Lokacija lokacija) {
        this.nazivRestorana = nazivRestorana;
        this.tipRestorana = tipRestorana;
        this.status_restorana = Status_restorana.RADI;
        //this.artikli = new ArrayList<>();
        //this.lista_porudzbina = new ArrayList<>();
        this.lokacija = lokacija;
    }
    public Restoran(Long id, String nazivRestorana, String tipRestorana, Lokacija lokacija) {
        this.id = id;
        this.nazivRestorana = nazivRestorana;
        this.tipRestorana = tipRestorana;
        this.status_restorana = Status_restorana.RADI;
        //this.artikli = new ArrayList<>();
        //this.lista_porudzbina = new ArrayList<>();
        this.lokacija = lokacija;
    }

    public Status_restorana getStatus_restorana() {
        return status_restorana;
    }

    public void setStatus_restorana(Status_restorana status_restorana) {
        this.status_restorana = status_restorana;
    }

    public Menadzer getMenadzer() {
        return menadzer;
    }

    public void setMenadzer(Menadzer menadzer) {
        this.menadzer = menadzer;
    }


    public Set<Porudzbina> getPorudzbine() {
        return porudzbine;
    }

    public void setPorudzbine(Set<Porudzbina> porudzbine) {
        this.porudzbine = porudzbine;
    }

    @OneToMany(mappedBy = "restoran", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Porudzbina> porudzbine = new HashSet<>();



    public Set<Artikal> getArtikli() {
        return artikli;
    }

    public void setArtikli(Set<Artikal> artikli) {
        this.artikli = artikli;
    }



    public Lokacija getLokacija() {
        return lokacija;
    }

    public void setLokacija(Lokacija lokacija) {
        this.lokacija = lokacija;
    }


    public String getNazivRestorana() {
        return nazivRestorana;
    }

    public void setNazivRestorana(String nazivRestorana) {
        this.nazivRestorana = nazivRestorana;
    }

    public String getTipRestorana() {
        return tipRestorana;
    }

    public void setTipRestorana(String tipRestorana) {
        this.tipRestorana = tipRestorana;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Komentar> getKomentari() {
        return komentari;
    }

    public void setKomentari(Set<Komentar> komentari) {
        this.komentari = komentari;
    }
}
