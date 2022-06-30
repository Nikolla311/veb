package vezbe.demo.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import vezbe.demo.model.*;

import java.util.*;

public class RestoranDto {

    private Long id;

    private String nazivRestorana;

    private String tipRestorana;

    private Status_restorana status_restorana;

    private Lokacija lokacija;

    private double ocenaRestorana;


    private Set<ArtikalDto> artikli;

    private Set<KomentarDto> komentari;

    //private int ocena;

    public double prosecnaOcena(Set<Komentar> komentariRestoran) {
        double s = 0;
        int b = 0;
        for (Komentar komentar : komentariRestoran) {
            s = s + komentar.getOcena();
            b ++;
        }
        s = s / b;
        s = Math.round(s * 100.0) / 100.0;
        return s;
    }

    public RestoranDto() {}
    public RestoranDto(Long id, String nazivRestorana, String tipRestorana, Lokacija lokacija) {
        this.id = id;
        this.nazivRestorana = nazivRestorana;
        this.tipRestorana = tipRestorana;
        this.status_restorana = Status_restorana.RADI;
        this.lokacija = lokacija;
        this.ocenaRestorana = 0;
        this.artikli = new HashSet<>();
        this.komentari = new HashSet<>();
    }
    public RestoranDto(Long id, String nazivRestorana, String tipRestorana, Lokacija lokacija, Set<Artikal> artikliRestoran, Set<Komentar> komentariRestoran) {
        this.id = id;
        this.nazivRestorana = nazivRestorana;
        this.tipRestorana = tipRestorana;
        this.status_restorana = Status_restorana.RADI;
        this.lokacija = lokacija;
        this.ocenaRestorana = prosecnaOcena(komentariRestoran);
        this.artikli = new HashSet<>();
        this.komentari = new HashSet<>();
        for (Artikal artikal : artikliRestoran) {
            ArtikalDto artikalDto = new ArtikalDto(artikal);
            this.artikli.add(artikalDto);
        }
        for (Komentar komentar : komentariRestoran) {
            KomentarDto komentarDto = new KomentarDto(komentar);
            this.komentari.add(komentarDto);
        }
    }


    public RestoranDto(Restoran restoran) {
        this.id = restoran.getId();
        this.nazivRestorana = restoran.getNazivRestorana();
        this.tipRestorana = restoran.getTipRestorana();
        this.status_restorana = restoran.getStatus_restorana();
        this.lokacija = restoran.getLokacija();
        this.ocenaRestorana = prosecnaOcena(restoran.getKomentari());
        this.artikli = new HashSet<>();
        this.komentari = new HashSet<>();
        for (Artikal artikal : restoran.getArtikli()) {
            ArtikalDto artikalDto = new ArtikalDto(artikal);
            this.artikli.add(artikalDto);
        }
        for (Komentar komentar : restoran.getKomentari()) {
            KomentarDto komentarDto = new KomentarDto(komentar);
            this.komentari.add(komentarDto);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<KomentarDto> getKomentari() {
        return komentari;
    }

    public void setKomentari(Set<KomentarDto> komentari) {
        this.komentari = komentari;
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

    public Status_restorana getStatus_restorana() {
        return status_restorana;
    }

    public void setStatus_restorana(Status_restorana status_restorana) {
        this.status_restorana = status_restorana;
    }

    public Lokacija getLokacija() {
        return lokacija;
    }

    public void setLokacija(Lokacija lokacija) {
        this.lokacija = lokacija;
    }

    public Set<ArtikalDto> getArtikli() {
        return artikli;
    }

    public void setArtikli(Set<ArtikalDto> artikli) {
        this.artikli = artikli;
    }


    /*public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }*/

    public double getOcenaRestorana() {
        return ocenaRestorana;
    }

    public void setOcenaRestorana(double ocenaRestorana) {
        this.ocenaRestorana = ocenaRestorana;
    }
}
