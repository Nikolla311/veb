package vezbe.demo.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.*;
import java.util.*;

@Entity
public class Lokacija implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    protected double g_duzina;
    @Column
    protected double g_sirina;
    @Column
    protected String adresa;

    /*@ManyToOne
    private Restoran restoran;*/

    //@OneToOne(mappedBy = "lokacija")
    //private Restoran restoran;

    @OneToMany(mappedBy = "lokacija", cascade = CascadeType.ALL)
    @JsonIgnore

    private Set<Restoran> restorani = new HashSet<>();

    public Lokacija() {
    }

    public Lokacija(double g_duzina, double g_sirina, String adresa) {
        this.g_duzina = g_duzina;
        this.g_sirina = g_sirina;
        this.adresa = adresa;
    }
    public Lokacija(Lokacija lokacija) {
        this.g_duzina = lokacija.getG_duzina();
        this.g_sirina = lokacija.getG_sirina();
        this.adresa = lokacija.getAdresa();
    }

    public double getG_duzina() {
        return g_duzina;
    }

    public void setG_duzina(double g_duzina) {
        this.g_duzina = g_duzina;
    }

    public double getG_sirina() {
        return g_sirina;
    }

    public void setG_sirina(double g_sirina) {
        this.g_sirina = g_sirina;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Restoran> getRestorani() {
        return restorani;
    }

    public void setRestorani(Set<Restoran> restorani) {
        this.restorani = restorani;
    }
}
