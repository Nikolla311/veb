package vezbe.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vezbe.demo.dto.PorudzbinaDto;
import vezbe.demo.model.Korisnik;
import vezbe.demo.model.Porudzbina;
import vezbe.demo.model.Uloga;
import vezbe.demo.service.PorudzbinaService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DostavljacRestController {


    @Autowired
    private PorudzbinaService porudzbinaService;

    @GetMapping("api/porudzbineZaDostavljaca")
    public ResponseEntity<?> svePorudzbineZaDostavljaca(HttpSession session){
        Korisnik ulogovanKorisnik = (Korisnik) session.getAttribute("korisnik");
        if(ulogovanKorisnik != null && ulogovanKorisnik.getUloga() != Uloga.DOSTAVLJAC) {
            return ResponseEntity.badRequest().body("");
        }
        List<Porudzbina> porudzbinas = porudzbinaService.findDostavljac(ulogovanKorisnik);
        List<PorudzbinaDto> nebitno = new ArrayList<>();
        for(Porudzbina p:porudzbinas) {
            PorudzbinaDto pdto = new PorudzbinaDto(p);
            nebitno.add(pdto);
        }
        return new ResponseEntity<>(nebitno, HttpStatus.OK);

    }

}

