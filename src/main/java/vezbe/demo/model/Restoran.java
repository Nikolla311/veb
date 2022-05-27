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
    //protected ArrayList<Artikal> artikli;
    //protected ArrayList<Porudzbina> lista_porudzbina;
    //@Column
    //protected Lokacija lokacija;

    /*@OneToMany(mappedBy = "restoran", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "lokacija_id")
    private Set<Lokacija> lokacije = new HashSet<>();*/

    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lokacija_id")
    private Lokacija lokacija;*/
    /*@ManyToOne
   // @JoinColumn(name = "restoran_id")
    protected Menadzer menadzer;*/

    @OneToMany(mappedBy = "restoran", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Artikal> artikli = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "lokacija_id")
    private Lokacija lokacija;

    public Set<Komentar> getKomentari() {
        return komentari;
    }

    public void setKomentari(Set<Komentar> komentari) {
        this.komentari = komentari;
    }
    @OneToOne(mappedBy = "restoran", cascade = CascadeType.ALL)
    @JsonIgnore
    protected Menadzer menadzer;

    @OneToMany(mappedBy = "komentar", cascade = CascadeType.ALL)
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


   /* @OneToMany(mappedBy = "restoran", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Komentar> komentari = new HashSet<>();*/


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

    /*public ArrayList<Porudzbina> getLista_porudzbina() {
        return lista_porudzbina;
    }*/

    /*public void setLista_porudzbina(ArrayList<Porudzbina> lista_porudzbina) {
        this.lista_porudzbina = lista_porudzbina;
    }*/

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

    /*public ArrayList<Artikal> getArtikli() {
        return artikli;
    }*/
    /*public void DodajArtikal(Artikal artikal) {
        artikli.add(artikal);
    }*/

    /*public void setArtikli(ArrayList<Artikal> artikli) {
        this.artikli = artikli;
    }*/

    /*public Lokacija getLokacija() {
        return lokacija;
    }


    public void setLokacija(Lokacija lokacija) {
        this.lokacija = lokacija;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   /* public Set<Komentar> getKomentari() {
        return komentari;
    }

    public void setKomentari(Set<Komentar> komentari) {
        this.komentari = komentari;
    }*/
}
