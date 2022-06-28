package vezbe.demo.dto;

public class RestoranLokacijaDto {
    protected Long idRestoran;
    protected String adresa;

    public RestoranLokacijaDto() {}

    public RestoranLokacijaDto(Long idRestoran, String adresa) {
        this.idRestoran = idRestoran;
        this.adresa = adresa;
    }

    public Long getIdRestoran() {
        return idRestoran;
    }

    public void setIdRestoran(Long idRestoran) {
        this.idRestoran = idRestoran;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
}
