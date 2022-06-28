package vezbe.demo.dto;



import vezbe.demo.model.*;

public class NewRestoranDto {

    private String nazivRestorana;

    private String tipRestorana;


    private Lokacija lokacija;

    public NewRestoranDto() {
    }

    public NewRestoranDto(String naziv_restorana, String tip_restorana, Lokacija lokacija) {
        this.nazivRestorana = naziv_restorana;
        this.tipRestorana = tip_restorana;
        //this.status_restorana = status_restorana;
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

    /*public Status_restorana getStatus_restorana() {
        return status_restorana;
    }

    public void setStatus_restorana(Status_restorana status_restorana) {
        this.status_restorana = status_restorana;
    }*/

    public Lokacija getLokacija() {
        return lokacija;
    }

    public void setLokacija(Lokacija lokacija) {
        this.lokacija = lokacija;
    }
}
