package vezbe.demo.dto;

public class LokacijaDto {
    private String adresa;

    public LokacijaDto() {

    }

    public LokacijaDto(String adresa) {
        this.adresa = adresa;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
}
