package vezbe.demo.model;


//enum Ocena {1,2 3, 4, 5};

import org.springframework.beans.factory.annotation.*;

import javax.persistence.*;
import java.io.*;

@Entity
public class Komentar implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Autowired
    @ManyToOne
    @JoinColumn(name = "kupac_id")
    protected Kupac kupac;
    @ManyToOne
    @JoinColumn(name = "restoran_id")
    protected Restoran restoran;
    //protected Restoran restoran;
    protected String komentar;
    //protected Ocena ocena;
    protected int ocena;

    public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }

    /*@Autowired
        @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        @JoinColumn(name = "restoran_id")
        protected Restoran restoran;
    */
    public Komentar() {
    }

    public Komentar(Kupac kupac, Restoran restoran, String komentar, int ocena) {
        this.kupac = kupac;
        this.restoran = restoran;
        this.komentar = komentar;
        this.ocena = ocena;
    }



    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    /*public Restoran getRestoran() {
        return restoran;
    }

    public void setRestoran(Restoran restoran) {
        this.restoran = restoran;
    }*/

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
