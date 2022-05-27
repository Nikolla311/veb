package vezbe.demo.dto;


import vezbe.demo.model.*;

import java.util.*;

public class RestoranDto {

    private Long id;

    private String nazivRestorana;

    private String tipRestorana;

    private Status_restorana status_restorana;

    private Lokacija lokacija;
    
    private Set<ArtikalDto> artikli;

    //private int ocena;

    public RestoranDto() {
    }
    public RestoranDto(Long id, String nazivRestorana, String tipRestorana, Lokacija lokacija) {
        this.id = id;
        this.nazivRestorana = nazivRestorana;
        this.tipRestorana = tipRestorana;
        this.status_restorana = Status_restorana.RADI;
        this.lokacija = lokacija;
        this.artikli = new HashSet<>();
    }
    public RestoranDto(Long id, String nazivRestorana, String tipRestorana, Lokacija lokacija, Set<Artikal> artikliRestoran) {
        this.id = id;
        this.nazivRestorana = nazivRestorana;
        this.tipRestorana = tipRestorana;
        this.status_restorana = Status_restorana.RADI;
        this.lokacija = lokacija;
        this.artikli = new HashSet<>();
        for (Artikal artikal : artikliRestoran) {
            ArtikalDto artikalDto = new ArtikalDto(artikal);
            this.artikli.add(artikalDto);
        }
    }


    public RestoranDto(Restoran restoran) {
        this.id = restoran.getId();
        this.nazivRestorana = restoran.getNazivRestorana();
        this.tipRestorana = restoran.getTipRestorana();
        this.status_restorana = restoran.getStatus_restorana();
        this.lokacija = restoran.getLokacija();
        this.artikli = new HashSet<>();
        for (Artikal artikal : restoran.getArtikli()) {
            ArtikalDto artikalDto = new ArtikalDto(artikal);
            this.artikli.add(artikalDto);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
