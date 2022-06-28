package vezbe.demo.dto;

import vezbe.demo.model.Komentar;

public class KomentarDto {
    protected String komentar;

    public KomentarDto() {}

    public KomentarDto(String komentar) {
        this.komentar = komentar;
    }

    public KomentarDto(Komentar komentar) {
        this.komentar = komentar.getKomentar();
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }
}
