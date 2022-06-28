package vezbe.demo.controller;


import com.fasterxml.jackson.databind.DatabindContext;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vezbe.demo.dto.*;
import vezbe.demo.model.*;
import vezbe.demo.service.*;

import javax.servlet.http.*;
import javax.validation.Valid;
import java.io.IOException;
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
    @GetMapping("/api/menadzer/restoran")
    public ResponseEntity<RestoranDto> getRestoran(HttpSession session) {
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        if (loggedKorisnik == null) {
            return new ResponseEntity("Nema sesije", HttpStatus.NOT_FOUND);
        }
        if (loggedKorisnik.getUloga() != Uloga.MENADZER) {
            return new ResponseEntity("Samo menadzer moze pogledati svoj restoran", HttpStatus.FORBIDDEN);
        }


        Menadzer menadzer = menadzerService.findOne(loggedKorisnik.getUsername());
        Restoran restoran = menadzer.getRestoran();
        RestoranDto restoranDto = new RestoranDto(restoran);

        if (restoran == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(restoranDto);
    }
    @PostMapping("/api/menadzer/add-artikal")
    public  ResponseEntity<ArtikalDto> addNewArtikal(@Valid @RequestBody ArtikalDto dto, HttpSession session) {
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        if (loggedKorisnik == null) {
            return new ResponseEntity("Nema sesije", HttpStatus.NOT_FOUND);
        }
        if (loggedKorisnik.getUloga() == Uloga.MENADZER) {

            Menadzer menadzer = menadzerService.findOne(loggedKorisnik.getUsername());
            //String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            Artikal artikal = new Artikal(dto.getNaziv(), dto.getCena(), dto.getKolicina(), dto.getTip_artikla(), dto.getOpis(), menadzer.getRestoran());
            Artikal savedArtikal = menadzerService.save(artikal);
            if (savedArtikal == null) {
                return new ResponseEntity(null, HttpStatus.CONFLICT);
            }
            ArtikalDto artikalDto = new ArtikalDto(savedArtikal.getId(), savedArtikal.getNaziv(), savedArtikal.getCena(), savedArtikal.getKolicina(), savedArtikal.getTip_artikla(), savedArtikal.getOpis());
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

    @DeleteMapping("api/menadzer/delete-artikal")
    public ResponseEntity<Long> deleteArtikal(@RequestBody Long id, HttpSession session){
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        if(loggedKorisnik == null){
            return new ResponseEntity("Nema sesije", HttpStatus.NOT_FOUND);
        }
        if (loggedKorisnik.getUloga() == Uloga.MENADZER) {
            Artikal artikal = menadzerService.findId(id);
            if (artikal == null) {
                return new ResponseEntity("Artikal nije pronadjen", HttpStatus.NOT_FOUND);
            }
            menadzerService.delete(id);

            if (menadzerService.findArtikal(id) == null) {
                return new ResponseEntity(id, HttpStatus.OK);
            } else {
                return new ResponseEntity("Artikal nije obrisan", HttpStatus.CONFLICT);
            }
        } else {
            return new ResponseEntity("Samo menadzer moze obrisati artikal", HttpStatus.FORBIDDEN);
        }
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

    @PostMapping("/api/menadzer/update-artikal")
    public ResponseEntity<ArtikalDto> artikalUpdate(@RequestBody ArtikalUpdateDto dto, HttpSession session){
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        if(loggedKorisnik == null){
            return new ResponseEntity("Nema sesije", HttpStatus.NOT_FOUND);
        }
        if (loggedKorisnik.getUloga() == Uloga.MENADZER) {
            Artikal artikal = menadzerService.findArtikal(dto.getId());
            if (artikal != null) {
                menadzerService.updateArtikal(dto);
            } else {
                    return new ResponseEntity("Artikal nije pronadjen", HttpStatus.NOT_FOUND);
            }
            ArtikalDto artikalDto = new ArtikalDto(artikal);
            return new ResponseEntity(artikalDto, HttpStatus.OK);
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

