package vezbe.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vezbe.demo.dto.PorudzbinaDto;
import vezbe.demo.model.Korisnik;
import vezbe.demo.model.Porudzbina;
import vezbe.demo.model.Uloga;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@RestController
public class KupacRestController {


    @GetMapping("api/porudzbine")
    public ResponseEntity<?> getPorudzbine(HttpSession session){

        return ResponseEntity.ok("");
    }

    @PostMapping("api/porudzbina")
    public ResponseEntity<?> porudzbina(@RequestBody PorudzbinaDto p, HttpSession session) {
        Korisnik ulogovanKorisnik = (Korisnik) session.getAttribute("korisnik");
        if(ulogovanKorisnik != null && ulogovanKorisnik.getUloga() != Uloga.KUPAC) {
            return ResponseEntity.badRequest().body("Samo kupac moze da poruci");
        }
        Porudzbina porudzbina = new Porudzbina(LocalDateTime.now(), 0, ulogovanKorisnik, null, null);
//        Tamara123: ranisovic123
        return ResponseEntity.ok("Porudzbina je napravljena");
    }

}
