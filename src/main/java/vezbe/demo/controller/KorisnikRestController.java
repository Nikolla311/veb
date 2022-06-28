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

@RestController
public class KorisnikRestController {

    @Autowired
    private KorisnikService korisnikService;
    @Autowired
    private KupacService kupacService;
    @GetMapping("/api/")
    public String welcome(){
        return "Hello from api!";
    }

    @PostMapping("api/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto, HttpSession session){
        // proverimo da li su podaci validni
        if(loginDto.getUsername().isEmpty() || loginDto.getLozinka().isEmpty())
            return new ResponseEntity("Invalid login data", HttpStatus.BAD_REQUEST);

        Korisnik loggedKorisnik = korisnikService.login(loginDto.getUsername(), loginDto.getLozinka());
        if (loggedKorisnik == null)
            return new ResponseEntity<>("User does not exist!", HttpStatus.NOT_FOUND);

        session.setAttribute("korisnik", loggedKorisnik);
        return ResponseEntity.ok("Successfully logged in!");
    }

    @PostMapping("api/logout")
    public ResponseEntity Logout(HttpSession session){
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");

        if (loggedKorisnik == null)
            return new ResponseEntity("Forbidden", HttpStatus.FORBIDDEN);

        session.invalidate();
        return new ResponseEntity("Successfully logged out", HttpStatus.OK);
    }

    @GetMapping("/api/korisnici")
    public ResponseEntity<List<KorisnikDto>> getKorisnici(HttpSession session){
        List<Korisnik> korisnikList = korisnikService.findAll();

        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        if(loggedKorisnik == null || loggedKorisnik.getUloga() != Uloga.ADMIN) {
            //System.out.println("Nema sesije");
            return ResponseEntity.notFound().build();
        }

        List<KorisnikDto> dtos = new ArrayList<>();
        for(Korisnik korisnik : korisnikList){
            KorisnikDto dto = new KorisnikDto(korisnik);
            dtos.add(dto);
        }
        return ResponseEntity.ok(dtos);
    }


    @PostMapping("/api/registracija")
    public String Registracija(@RequestBody KupacDto kupacDto) {
        Kupac kupac = new Kupac(kupacDto.getUsername(), kupacDto.getPol(), kupacDto.getLozinka(), kupacDto.getIme(), kupacDto.getPrezime(), kupacDto.getDatum_rodjenja());


        this.kupacService.saveKupac(kupac);
        return "Registracija uspesna";
    }


    @GetMapping("/api/korisnik/{username}")
    public ResponseEntity<KorisnikDto> getKorisnik(@PathVariable String username, HttpSession session) {
        Korisnik loggedKorisnik = (Korisnik) session.getAttribute("korisnik");
        if(loggedKorisnik == null) {
            return new ResponseEntity("Nema sesije", HttpStatus.NOT_FOUND);
        }
        Korisnik korisnik = korisnikService.findOne(username);
        if (korisnik == null) {
            return new ResponseEntity("Korisnik nije pronadjen", HttpStatus.NOT_FOUND);
        } else {
            if (korisnik.getUsername().equals(loggedKorisnik.getUsername())) {
                KorisnikDto dto = new KorisnikDto(korisnik);
                return ResponseEntity.ok(dto);
            } else {
                return new ResponseEntity("Mozete pogledati samo svoje podatke", HttpStatus.FORBIDDEN);
            }
        }



    }



    /*@PutMapping("/api/employees/projects/{id}")
    public ResponseEntity<EmployeeDto> addProject(@PathVariable Long id, HttpSession session) {
        Employee loggedEmployee = (Employee) session.getAttribute("employee");
        if(loggedEmployee == null) {
            System.out.println("Nema sesije");
            return ResponseEntity.notFound().build();
        } else {
            System.out.println(loggedEmployee);
        }

        Employee updatedEmployee = employeeService.addProject(loggedEmployee.getId(), id);
        if(updatedEmployee == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(new EmployeeDto(updatedEmployee));

    }*/
}
