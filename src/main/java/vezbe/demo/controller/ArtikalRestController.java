package vezbe.demo.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import vezbe.demo.model.*;
import vezbe.demo.service.*;

import java.util.*;

@RestController
public class ArtikalRestController {

    @Autowired
    private ArtikalService artikalservice;

    /*@GetMapping("/api/")
    public String welcome(){
        return "Hello from api!";
    }*/

    @GetMapping("/api/artikli")
    public List<Artikal> getArtikli(){
        List<Artikal> artikalList = artikalservice.findAll();

        return artikalList;
    }

    @GetMapping("/api/artikli/{id}")
    public Artikal getArtikal(@PathVariable(name = "id") Long id){
        Artikal artikal = artikalservice.findOne(id);
        return artikal;
    }

    /*@PostMapping("/api/save-artikal")
    public String saveArtikal(@RequestBody Artikal artikal) {
        this.artikalservice.save(artikal);
        return "Successfully saved an Artikal!";
    }*/
}
