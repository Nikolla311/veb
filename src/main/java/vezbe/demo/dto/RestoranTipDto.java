package vezbe.demo.dto;

public class RestoranTipDto {
    protected Long idRestoran;
    protected String tip;

    public RestoranTipDto() {}

    public RestoranTipDto(Long idRestoran, String tip) {
        this.idRestoran = idRestoran;
        this.tip = tip;
    }

    public Long getIdRestoran() {
        return idRestoran;
    }

    public void setIdRestoran(Long idRestoran) {
        this.idRestoran = idRestoran;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
