package vezbe.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vezbe.demo.dto.*;
import vezbe.demo.model.*;
import vezbe.demo.service.*;

import javax.servlet.http.HttpSession;
import java.util.*;

@RestController
@RequestMapping("/api/restorani")
public class RestoranRestController {

    @Autowired
    private RestoranService restoranService;

    //private final DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    @GetMapping("/all")
    public ResponseEntity<List<NewRestoranDto>> getRestorani(HttpSession session){
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        List<Restoran> restorani;
        if(loggedKorisnik == null)
            return new ResponseEntity("Nema sesije", HttpStatus.FORBIDDEN);
        else
            restorani = restoranService.findAll();

        List<NewRestoranDto> restoranDtos = new ArrayList<>();
        //Set<Artikal> artikli = new HashSet<>();
        //Set<ArtikalDto> artikliDto = new HashSet<>();
        for (Restoran restoran: restorani) {

            NewRestoranDto dto = new NewRestoranDto(restoran.getNazivRestorana(), restoran.getTipRestorana(), restoran.getLokacija());
            restoranDtos.add(dto);
        }

        return ResponseEntity.ok(restoranDtos);
    }
    @GetMapping("/naziv/{nazivRestorana}")
    public ResponseEntity<List<RestoranDto>> getRestoranNaziv(@PathVariable String nazivRestorana, HttpSession session) {
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        if (loggedKorisnik == null) {
            return new ResponseEntity("Nema sesije", HttpStatus.NOT_FOUND);
        }
        List<Restoran> restorani = restoranService.findNaziv(nazivRestorana);
        List<RestoranDto> restoranDtos = new ArrayList<>();
        //Set<ArtikalDto> artikliDto = new HashSet<>();
        //Set<Artikal> artikli = new HashSet<>();
        //Set<ArtikalDto> artikliDto = new HashSet<>();
        for (Restoran restoran: restorani) {

            RestoranDto dto = new RestoranDto(restoran.getId(), restoran.getNazivRestorana(), restoran.getTipRestorana(), restoran.getLokacija(), restoran.getArtikli(), restoran.getKomentari());
            restoranDtos.add(dto);
        }
        return ResponseEntity.ok(restoranDtos);
    }
    @GetMapping("/tip/{tipRestorana}")
    public ResponseEntity<List<RestoranDto>> getRestoranTip(@PathVariable String tipRestorana, HttpSession session) {
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        if (loggedKorisnik == null) {
            return new ResponseEntity("Nema sesije", HttpStatus.NOT_FOUND);
        }
        List<Restoran> restorani = restoranService.findTip(tipRestorana);
        List<RestoranDto> restoranDtos = new ArrayList<>();
        //Set<ArtikalDto> artikliDto = new HashSet<>();
        //Set<Artikal> artikli = new HashSet<>();
        //Set<ArtikalDto> artikliDto = new HashSet<>();
        for (Restoran restoran: restorani) {

            RestoranDto dto = new RestoranDto(restoran.getId(), restoran.getNazivRestorana(), restoran.getTipRestorana(), restoran.getLokacija(), restoran.getArtikli(), restoran.getKomentari());
            restoranDtos.add(dto);
        }

        return ResponseEntity.ok(restoranDtos);
    }
    @PostMapping("/lokacija")
    public ResponseEntity<List<RestoranDto>> getRestoranLokacija(@RequestBody String adresa, HttpSession session) {
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        if (loggedKorisnik == null) {
            return new ResponseEntity("Nema sesije", HttpStatus.NOT_FOUND);
        }
        //List<Restoran> restorani = restoranService.findLokacija(adresa);
        //List<RestoranDto> restoranDtos = new ArrayList<>();

        List<Restoran> restorani = restoranService.findLokacija(adresa);
        List<RestoranDto> restoranDtos = new ArrayList<>();
        //Set<ArtikalDto> artikliDto = new HashSet<>();
        //Set<Artikal> artikli = new HashSet<>();
        //Set<ArtikalDto> artikliDto = new HashSet<>();
        for (Restoran restoran: restorani) {
            
                RestoranDto restoranDto = new RestoranDto(restoran.getId(), restoran.getNazivRestorana(), restoran.getTipRestorana(), restoran.getLokacija(), restoran.getArtikli(), restoran.getKomentari());
                restoranDtos.add(restoranDto);
            //}
        }
        /*for (Restoran restoran : restorani) {
            RestoranDto dto = new RestoranDto(restoran.getNazivRestorana(), restoran.getTipRestorana(), restoran.getStatus_restorana(), restoran.getLokacija());
            restoranDtos.add(dto);
        }*/

        if (restoranDtos.isEmpty()) {
            return new ResponseEntity("Nema restorana sa datom lokacijom", HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(restoranDtos);
        }
    }

    /*@PostMapping("/save-restoran")
    public String saveRestoran(@RequestBody Restoran restoran) {
        this.restoranService.save(restoran);
        return "Successfully saved a Restoran!";
    }*/



    /*@PostMapping("/save-restoran")
    public  ResponseEntity<RestoranDto> addNewRestoran(@RequestBody NewRestoranDto dto) {
        if(dto.getNaziv_restorana().isEmpty() || dto.getTip_restorana().isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        /*Date deadline;
        try {
            deadline = formatter.parse(dto.getDeadline());
        } catch (ParseException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        Restoran restoran = new Restoran(dto.getNaziv_restorana(), dto.getTip_restorana(), dto.getStatus_restorana(), dto.getLokacija());
        Restoran savedRestoran = restoranService.save(restoran);
        if(savedRestoran == null)
            return new ResponseEntity(null, HttpStatus.CONFLICT);
        RestoranDto restoranDto = new RestoranDto(savedRestoran.getNaziv_restorana(), savedRestoran.getTip_restorana(), dto.getStatus_restorana(), savedRestoran.getLokacija());
        return new ResponseEntity(restoranDto, HttpStatus.CREATED);
    }*/
}
