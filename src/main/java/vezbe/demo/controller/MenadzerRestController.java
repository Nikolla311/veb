package vezbe.demo.controller;


import com.fasterxml.jackson.databind.DatabindContext;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import vezbe.demo.dto.*;
import vezbe.demo.model.*;
import vezbe.demo.service.*;

import javax.servlet.http.*;
import java.util.*;

@RestController
//@RequestMapping("/api/menadzer")
public class MenadzerRestController {

    @Autowired
    private MenadzerService menadzerService;
    @Autowired
    private PorudzbinaService porudzbinaService;

    @GetMapping("/api/menadzer/{username}")
    public ResponseEntity<MenadzerDto> getMenadzer(@PathVariable String username, HttpSession session) {
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        if(loggedKorisnik == null) {
            return new ResponseEntity("Nema sesije", HttpStatus.NOT_FOUND);
        }
        Menadzer menadzer = menadzerService.findOne(username);
        if (menadzer == null) {
            return new ResponseEntity("Menadzer nije pronadjen", HttpStatus.NOT_FOUND);
        } else {
            if (menadzer.getUsername().equals(loggedKorisnik.getUsername())) {
                MenadzerDto dto = new MenadzerDto(menadzer);
                return ResponseEntity.ok(dto);
            } else {
                return new ResponseEntity("Mozete pogledati samo svoje podatke", HttpStatus.FORBIDDEN);
            }
        }

    }
    @PostMapping("/add-artikal")
    public  ResponseEntity<ArtikalDto> addNewArtikal(@RequestBody ArtikalDto dto, HttpSession session) {
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        if (loggedKorisnik == null) {
            return new ResponseEntity("Nema sesije", HttpStatus.NOT_FOUND);
        }
        if (loggedKorisnik.getUloga() == Uloga.MENADZER) {
            if (dto.getNaziv().isEmpty()) {
                return ResponseEntity.badRequest().build();
            }

            Menadzer menadzer = menadzerService.findOne(loggedKorisnik.getUsername());
            Artikal artikal = new Artikal(dto.getNaziv(), dto.getCena(), dto.getTip_artikla(), menadzer.getRestoran());
            Artikal savedArtikal = menadzerService.save(artikal);
            if (savedArtikal == null) {
                return new ResponseEntity(null, HttpStatus.CONFLICT);
            }
            ArtikalDto artikalDto = new ArtikalDto(savedArtikal.getId(), savedArtikal.getNaziv(), savedArtikal.getCena(), savedArtikal.getTip_artikla());
            return new ResponseEntity(artikalDto, HttpStatus.CREATED);
        } else {
            return new ResponseEntity("Samo menadzer moze dodati novi artikal", HttpStatus.FORBIDDEN);
        }
    }

    /*@PostMapping("/api/menadzer/save-restoran")
    public String saveRestoran(@RequestBody Restoran restoran, HttpSession session) {
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        if (loggedKorisnik == null) {
            return "Nema sesije";
        }
        if (loggedKorisnik.getUloga() == Uloga.MENADZER) {
            this.adminService.save(restoran);
            return "Successfully saved a Restoran!";
        } else {
            return "Admin ili menadzer moze dodati novi restoran";
        }
    }*/

    @DeleteMapping("api/delet-artikal")
    public ResponseEntity<Long> deletArtikal(@RequestBody Long id, HttpSession session){
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        if(loggedKorisnik == null){
            return new ResponseEntity("Nema sesije", HttpStatus.NOT_FOUND);
        }
        Artikal artikal = menadzerService.findId(id);
        if(artikal == null){
            return new ResponseEntity<>(id, HttpStatus.NOT_FOUND);
        }
        menadzerService.delete(id);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }




    @PostMapping("/api/menadzer/set-menadzer-artikalnaziv")
    public ResponseEntity<ArtikalDto> setArtikalNaziv(@RequestBody String naziv, HttpSession session){
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        if(loggedKorisnik == null){
            return new ResponseEntity("Nema sesije", HttpStatus.NOT_FOUND);
        }
        Artikal artikal = menadzerService.findArtikal(naziv);
        if(loggedKorisnik.getUloga() == Uloga.MENADZER){
            if(artikal == null){
                return ResponseEntity.badRequest().build();
            }
            artikal.setNaziv(naziv);
            ArtikalDto artikalDto = new ArtikalDto(artikal);
            return new ResponseEntity(artikalDto, HttpStatus.CREATED);
        } else {
            return new ResponseEntity("Samo menadzer moze da menja naziv artkla", HttpStatus.FORBIDDEN);
        }

    }


    @GetMapping("api/porudzbineZaMenadzera")
    public ResponseEntity<?> svePorudzbineZaMenadzera(HttpSession session){
        Korisnik ulogovanKorisnik = (Korisnik) session.getAttribute("korisnik");
        if(ulogovanKorisnik != null && ulogovanKorisnik.getUloga() != Uloga.MENADZER) {
            return ResponseEntity.badRequest().body("");
        }
        List<Porudzbina> porudzbinas = porudzbinaService.findMenadzer(ulogovanKorisnik);
        List<PorudzbinaDto> nebitno = new ArrayList<>();
        for(Porudzbina p:porudzbinas) {
            PorudzbinaDto pdto = new PorudzbinaDto(p);
            nebitno.add(pdto);
        }
        return new ResponseEntity<>(nebitno, HttpStatus.OK);

    }

}

