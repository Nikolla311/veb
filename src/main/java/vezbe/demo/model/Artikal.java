package vezbe.demo.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.*;
import java.util.*;

//enum Tip_artikla {JELO, PICE};
@Entity

public class Artikal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    protected String naziv;
    @Column
    protected double cena;

    @Enumerated(EnumType.STRING)
    @Column
    protected Tip_artikla tip_artikla;

    @Column
    protected double kolicina;
    @Column
    protected String opis;

    /*@JsonIgnore
    protected String photos;*/

    public Set<ArtikalPorudzbina> getArtikalporudzbina() {
        return artikalporudzbina;
    }

    public void setArtikalporudzbina(Set<ArtikalPorudzbina> artikalporudzbina) {
        this.artikalporudzbina = artikalporudzbina;
    }

    @ManyToOne
    @JoinColumn(name = "restoran_id")
    protected Restoran restoran;


    @OneToMany(mappedBy = "artikal", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<ArtikalPorudzbina> artikalporudzbina = new HashSet<>();


    public Artikal() {
    }

    public Artikal(String naziv, double cena, Tip_artikla tip_artikla, double kolicina, String opis, Restoran restoran) {
        this.naziv = naziv;
        this.cena = cena;
        this.tip_artikla = tip_artikla;
        this.kolicina = kolicina;
        this.opis = opis;
        this.restoran = restoran;
        //this.photos = photos;
    }
    public Artikal(String naziv, double cena, double kolicina, Tip_artikla tip_artikla, String opis, Restoran restoran) {
        this.naziv = naziv;
        this.cena = cena;
        this.kolicina = kolicina;
        this.tip_artikla = tip_artikla;
        this.restoran = restoran;
        this.opis = opis;
        //this.photos = photos;
    }


    public String getNaziv() {
        return naziv;
    }

    public Tip_artikla getTip_artikla() {
        return tip_artikla;
    }

    public void setTip_artikla(Tip_artikla tip_artikla) {
        this.tip_artikla = tip_artikla;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public double getKolicina() {
        return kolicina;
    }

    public void setKolicina(double kolicina) {
        this.kolicina = kolicina;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }

   /* public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }*/
}
