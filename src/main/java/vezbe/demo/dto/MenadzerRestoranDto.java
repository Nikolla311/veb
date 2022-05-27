package vezbe.demo.dto;

public class MenadzerRestoranDto {
    protected Long idRestoran;
    protected Long idMenadzer;
    
    public MenadzerRestoranDto() {
        
    }

    public MenadzerRestoranDto(Long idRestoran, Long idMenadzer) {

        this.idRestoran = idRestoran;
        this.idMenadzer = idMenadzer;
    }
    
    
    public Long getIdRestoran() {
        return idRestoran;
    }

    public void setIdRestoran(Long idRestoran) {
        this.idRestoran = idRestoran;
    }

    public Long getIdMenadzer() {
        return idMenadzer;
    }

    public void setIdMenadzer(Long idMenadzer) {
        this.idMenadzer = idMenadzer;
    }

   
}
