package vezbe.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vezbe.demo.dto.*;
import vezbe.demo.model.*;
import vezbe.demo.service.*;


import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class AdminRestController {

    @Autowired
    private AdminService adminService;



    @GetMapping("/api/admin/{username}")
    public ResponseEntity<AdminDto> getAdmin(@PathVariable String username, HttpSession session) {
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        if (loggedKorisnik == null) {
            return new ResponseEntity("Nema sesije", HttpStatus.NOT_FOUND);
        }
        Admin admin = adminService.findOne(username);
        if (admin == null) {
            return new ResponseEntity("Korisnik nije pronadjen", HttpStatus.NOT_FOUND);
        } else {
            if (admin.getUsername().equals(loggedKorisnik.getUsername())) {
                AdminDto dto = new AdminDto(admin);
                return ResponseEntity.ok(dto);
            } else {
                return new ResponseEntity("Mozete pogledati samo svoje podatke", HttpStatus.FORBIDDEN);
            }
        }
    }


    /*@PostMapping("/api/admin/save-menadzer")
    public String saveMenadzer(@RequestBody Menadzer menadzer, HttpSession session) {
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        if (loggedKorisnik == null) {
            return "Nema sesije";
        }
        if (loggedKorisnik.getUloga() == Uloga.ADMIN) {
            this.adminService.save(menadzer);
            return "Successfully saved a Menadzer!";
        } else {
            return "Samo admin moze dodati novog menadzera";
        }
    }*/
   /* @PostMapping("/api/admin/save-dostavljac")
    public String saveDostavljac(@RequestBody Dostavljac dostavljac, HttpSession session) {
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        if (loggedKorisnik == null) {
            return "Nema sesije";
        }
        if (loggedKorisnik.getUloga() == Uloga.ADMIN) {
            this.adminService.save(dostavljac);
            return "Successfully saved a Dostavljac!";
        } else {
            return "Samo admin moze dodati novog dostavljaca";
        }
    }*/
    @PostMapping("/api/admin/add-menadzer")
    public  ResponseEntity<MenadzerDto> addNewMenadzer(@RequestBody MenadzerDto dto, HttpSession session) {
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        if (loggedKorisnik == null) {
            return new ResponseEntity("Nema sesije", HttpStatus.NOT_FOUND);
        }
        if (loggedKorisnik.getUloga() == Uloga.ADMIN) {
            if (dto.getUsername().isEmpty() || dto.getLozinka().isEmpty() || dto.getIme().isEmpty() || dto.getPrezime().isEmpty() || dto.getPol() == null || dto.getDatum_rodjenja() == null || dto.getUloga() != Uloga.MENADZER) {
                return ResponseEntity.badRequest().build();
            }

            Menadzer menadzer = new Menadzer(dto.getUsername(), dto.getPol(), dto.getLozinka(), dto.getIme(), dto.getPrezime(),  dto.getDatum_rodjenja());
            Menadzer savedMenadzer = adminService.save(menadzer);
            if (savedMenadzer == null) {
                return new ResponseEntity(null, HttpStatus.CONFLICT);
            }
            MenadzerDto menadzerDto = new MenadzerDto(savedMenadzer.getUsername(), savedMenadzer.getLozinka(), savedMenadzer.getIme(), savedMenadzer.getPrezime(), savedMenadzer.getPol(), savedMenadzer.getDatum_rodjenja());
            return new ResponseEntity(menadzerDto, HttpStatus.CREATED);
        } else {
            return new ResponseEntity("Samo admin moze dodati novog menadzera", HttpStatus.FORBIDDEN);
        }
    }
    @PostMapping("/api/admin/add-dostavljac")
    public  ResponseEntity<DostavljacDto> addNewDostavljac(@RequestBody DostavljacDto dto, HttpSession session) {
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        if (loggedKorisnik == null) {
            return new ResponseEntity("Nema sesije", HttpStatus.NOT_FOUND);
        }
        if (loggedKorisnik.getUloga() == Uloga.ADMIN) {
            if (dto.getUsername().isEmpty() || dto.getLozinka().isEmpty() || dto.getIme().isEmpty() || dto.getPrezime().isEmpty() || dto.getPol() == null || dto.getDatum_rodjenja() == null || dto.getUloga() != Uloga.DOSTAVLJAC) {
                return ResponseEntity.badRequest().build();
            }

            Dostavljac dostavljac = new Dostavljac(dto.getUsername(), dto.getPol(), dto.getLozinka(), dto.getIme(), dto.getPrezime(),  dto.getDatum_rodjenja());
            Dostavljac savedDostavljac = adminService.save(dostavljac);
            if (savedDostavljac == null) {
                return new ResponseEntity(null, HttpStatus.CONFLICT);
            }
            DostavljacDto dostavljacDto = new DostavljacDto(savedDostavljac.getUsername(), savedDostavljac.getLozinka(), savedDostavljac.getIme(), savedDostavljac.getPrezime(), savedDostavljac.getPol(), savedDostavljac.getDatum_rodjenja());
            return new ResponseEntity(dostavljacDto, HttpStatus.CREATED);
        } else {
            return new ResponseEntity("Samo admin moze dodati novog dostavljaca", HttpStatus.FORBIDDEN);
        }
    }
    @PostMapping("/api/admin/add-restoran")
    public  ResponseEntity<RestoranDto> addNewRestoran(@RequestBody NewRestoranDto dto, HttpSession session) {
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        if (loggedKorisnik == null) {
            return new ResponseEntity("Nema sesije", HttpStatus.NOT_FOUND);
        }
        if (loggedKorisnik.getUloga() == Uloga.ADMIN) {
            if (dto.getNazivRestorana().isEmpty() || dto.getTipRestorana().isEmpty() || dto.getLokacija() == null) {
                return ResponseEntity.badRequest().build();
            }

            Restoran restoran = new Restoran(dto.getNazivRestorana(), dto.getTipRestorana(), dto.getLokacija());
            Restoran savedRestoran = adminService.saveRestoran(restoran);
            if (savedRestoran == null) {
                return new ResponseEntity(null, HttpStatus.CONFLICT);
            }
            RestoranDto restoranDto = new RestoranDto(savedRestoran.getId(), savedRestoran.getNazivRestorana(), savedRestoran.getTipRestorana(), savedRestoran.getLokacija());
            return new ResponseEntity(restoranDto, HttpStatus.CREATED);
        } else {
            return new ResponseEntity("Samo admin moze dodati novi restoran", HttpStatus.FORBIDDEN);
        }
    }

    /*@PatchMapping("/api/admin/set-menadzer-restoran1")
    public ResponseEntity<?> partialUpdateName(@RequestBody MenadzerRestoranDto dto, HttpSession) {

        adminService.saveUpdate(dto.getIdMenadzer(), dto.getIdRestoran());

        return ResponseEntity.ok("resource address updated");
    }*/
    @PatchMapping("/api/admin/set-menadzer-restoran")
    public  ResponseEntity<String> setRestoran(@RequestBody MenadzerRestoranDto dto, HttpSession session) {
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        if (loggedKorisnik == null) {
            return new ResponseEntity("Nema sesije", HttpStatus.NOT_FOUND);
        }
        if (loggedKorisnik.getUloga() == Uloga.ADMIN) {
            Restoran restoran = adminService.findRestoran(dto.getIdRestoran());
            Menadzer menadzer = adminService.findMenadzer(dto.getIdMenadzer());

            if (restoran == null || menadzer == null) {
                return ResponseEntity.badRequest().build();
            }
            //adminService.saveUpdate(dto);
            if (adminService.updateMenadzerRestoran(dto)) {
                //menadzer.setRestoran(restoran);
                //adminService.save(menadzer);
                //MenadzerDto menadzerDto = new MenadzerDto(menadzer);

                return new ResponseEntity("Uspesno odabran restoran za menadzera", HttpStatus.OK);
            } else {
                return new ResponseEntity("Uneti restoran vec ima menadzera", HttpStatus.CONFLICT);
            }
        } else {
            return new ResponseEntity("Samo admin moze dodeliti restoran menadzeru", HttpStatus.FORBIDDEN);
        }
    }
    @PatchMapping("/api/admin/set-ime")
    public  ResponseEntity<String> setIme(@RequestBody String ime, HttpSession session) {
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        if (loggedKorisnik == null) {
            return new ResponseEntity("Nema sesije", HttpStatus.NOT_FOUND);
        }
        if (loggedKorisnik.getUloga() == Uloga.ADMIN) {

            adminService.saveUpdateIme(loggedKorisnik.getId(), ime);
            //loggedKorisnik.setIme(ime);
            //menadzer.setRestoran(restoran);
            //adminService.save(admin);
            //MenadzerDto menadzerDto = new MenadzerDto(menadzer);
            return new ResponseEntity("Uspesno promenjeno ime", HttpStatus.OK);
        } else {
            return new ResponseEntity("Samo admin moze dodeliti restoran menadzeru", HttpStatus.FORBIDDEN);
        }
    }
    @PatchMapping("/api/admin/set/restoran/ime")
    public  ResponseEntity<String> updateRestoranIme(@RequestBody RestoranImeDto dto, HttpSession session) {
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        if (loggedKorisnik == null) {
            return new ResponseEntity("Nema sesije", HttpStatus.NOT_FOUND);
        }
        if (loggedKorisnik.getUloga() == Uloga.ADMIN) {

            adminService.saveUpdateRestoranIme(dto.getIdRestoran(), dto.getNaziv());
            //loggedKorisnik.setIme(ime);
            //menadzer.setRestoran(restoran);
            //adminService.save(admin);
            //MenadzerDto menadzerDto = new MenadzerDto(menadzer);
            return new ResponseEntity("Uspesno promenjeno ime restorana", HttpStatus.OK);
        } else {
            return new ResponseEntity("Samo admin moze dodeliti restoran menadzeru", HttpStatus.FORBIDDEN);
        }
    }
    @PatchMapping("/api/admin/set/restoran/tip")
    public  ResponseEntity<String> updateRestoranTip(@RequestBody RestoranTipDto dto, HttpSession session) {
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        if (loggedKorisnik == null) {
            return new ResponseEntity("Nema sesije", HttpStatus.NOT_FOUND);
        }
        if (loggedKorisnik.getUloga() == Uloga.ADMIN) {

            adminService.saveUpdateRestoranTip(dto.getIdRestoran(), dto.getTip());
            //loggedKorisnik.setIme(ime);
            //menadzer.setRestoran(restoran);
            //adminService.save(admin);
            //MenadzerDto menadzerDto = new MenadzerDto(menadzer);
            return new ResponseEntity("Uspesno promenjen tip restorana", HttpStatus.OK);
        } else {
            return new ResponseEntity("Samo admin moze dodeliti restoran menadzeru", HttpStatus.FORBIDDEN);
        }
    }
    @PatchMapping("/api/admin/set/restoran/lokacija")
    public  ResponseEntity<String> updateRestoranLokacija(@RequestBody RestoranLokacijaDto dto, HttpSession session) {
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        if (loggedKorisnik == null) {
            return new ResponseEntity("Nema sesije", HttpStatus.NOT_FOUND);
        }
        if (loggedKorisnik.getUloga() == Uloga.ADMIN) {

            adminService.saveUpdateRestoranLokacija(dto.getIdRestoran(), dto.getAdresa());
            //loggedKorisnik.setIme(ime);
            //menadzer.setRestoran(restoran);
            //adminService.save(admin);
            //MenadzerDto menadzerDto = new MenadzerDto(menadzer);
            return new ResponseEntity("Uspesno promenjena adresa restorana", HttpStatus.OK);
        } else {
            return new ResponseEntity("Samo admin moze dodeliti restoran menadzeru", HttpStatus.FORBIDDEN);
        }
    }

/*
    @PostMapping("/api/admin/save-dostavljac")
    public String saveDostavljac(@RequestBody Dostavljac dostavljac, HttpSession session) {
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        if (loggedKorisnik == null) {
            return "Nema sesije";
        }
        if (loggedKorisnik.getUloga() == Uloga.ADMIN) {
            this.adminService.save(dostavljac);
            return "Successfully saved a Dostavljac!";
        } else {
            return "Samo admin moze dodati novog dostavljaca";
        }
    }*/


}