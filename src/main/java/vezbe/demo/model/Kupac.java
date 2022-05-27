package vezbe.demo.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.*;
import java.util.*;

@Entity
public class Kupac extends Korisnik implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //protected ArrayList<Porudzbina> porudzbine_kupca;
    @Column
    protected int br_sakupljenih_bodova;
    //@Column
    //protected Tip_kupca tip_kupca;
    //protected ArrayList<K>
    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ime_tip_kupca")
    protected Tip_kupca tip_kupca;*/

    @ManyToOne
    @JoinColumn(name = "ime_tip_kupca")
    protected Tip_kupca tip_kupca;

    public Kupac() {
    }

    public Kupac(String korisnicko_ime, Pol pol, String lozinka, String ime, String prezime, Date datum_rodjenja) {
        super(korisnicko_ime, pol, lozinka, ime, prezime, datum_rodjenja, Uloga.KUPAC);
        this.br_sakupljenih_bodova = 0;
        //this.status_prijave = false;
        //this.porudzbine_kupca = new ArrayList<>();
       //this.tip_kupca = Ime_tip_kupca.BRONZANI;
        //setUloga(Uloga.KUPAC);

    }

    public Set<Komentar> getKomentari() {
        return komentari;
    }

    public void setKomentari(Set<Komentar> komentari) {
        this.komentari = komentari;
    }

    @OneToMany(mappedBy = "kupac", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Porudzbina> porudzbine_kupca = new HashSet<>();

    @OneToMany(mappedBy = "kupac", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Komentar> komentari = new HashSet<>();

    /*@OneToMany(mappedBy = "kupac", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Komentar> komentari = new HashSet<>();

    public Set<Komentar> getKomentari() {
        return komentari;
    }

    public void setKomentari(Set<Komentar> komentari) {
        this.komentari = komentari;
    }*/

    //@OneToOne(mappedBy = "lokacija")
    //private Restoran restoran;





    /*public boolean ProveraPrijave() {
        if (status_prijave) {
            return true;
        } else {
            return false;
        }
    }*/
    //public boolean Prijava(String korisnicko_ime, String lozinka) {
        /*if (!status_prijave) {
            for (Kupac k : lista_kupaca) {
                if (k.getKorisnicko_ime(),equals(korisnicko_ime)) {
                    if (k.getLozinka().equals(lozinka)) {
                        setStatus_prijave(true);
                        return true;
                    }
                }
            }
        } else {
            return false;
        }*/
    //}

    //public boolean IzmenaPodataka() {

    //}


    /*public ArrayList<Porudzbina> getPorudzbine_kupca() {
        return porudzbine_kupca;
    }*/

    /*public void setPorudzbine_kupca(ArrayList<Porudzbina> porudzbine_kupca) {
        this.porudzbine_kupca = porudzbine_kupca;
    }*/

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Set<Porudzbina> getPorudzbine_kupca() {
        return porudzbine_kupca;
    }

    public void setPorudzbine_kupca(Set<Porudzbina> porudzbine_kupca) {
        this.porudzbine_kupca = porudzbine_kupca;
    }

    public int getBr_sakupljenih_bodova() {
        return br_sakupljenih_bodova;
    }

    public void setBr_sakupljenih_bodova(int br_sakupljenih_bodova) {
        this.br_sakupljenih_bodova = br_sakupljenih_bodova;
    }

    public Tip_kupca getTip_kupca() {
        return tip_kupca;
    }

    public void setTip_kupca(Tip_kupca tip_kupca) {
        this.tip_kupca = tip_kupca;
    }
}
