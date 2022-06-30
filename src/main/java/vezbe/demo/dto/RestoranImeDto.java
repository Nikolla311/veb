package vezbe.demo.dto;

public class RestoranImeDto {
    protected Long idRestoran;
    protected String naziv;

    public RestoranImeDto() {}

    public RestoranImeDto(Long idRestoran, String naziv) {
        this.idRestoran = idRestoran;
        this.naziv = naziv;
    }

    public Long getIdRestoran() {
        return idRestoran;
    }

    public void setIdRestoran(Long idRestoran) {
        this.idRestoran = idRestoran;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
