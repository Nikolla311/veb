package vezbe.demo.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import vezbe.demo.model.*;
import vezbe.demo.repository.*;

import java.util.*;

@Service
public class MenadzerService {
    @Autowired
    private MenadzerRepository menadzerRepository;

    @Autowired
    private ArtikalRepository artikalRepository;

    public Menadzer findOne(String username) {
        Optional<Menadzer> foundMenadzer = menadzerRepository.findByUsername(username);
        return foundMenadzer.orElse(null);
    }

    public Artikal findArtikal(String naziv) {
        Optional<Artikal> foundArtikal = artikalRepository.findByNaziv(naziv);
        return foundArtikal.orElse(null);
    }

    public Artikal findId(Long id) {
        Optional<Artikal> foundArtikal = artikalRepository.findById(id);
        return foundArtikal.orElse(null);
    }


    public List<Menadzer> findAll() {
        return menadzerRepository.findAll();
    }

    public Menadzer save(Menadzer menadzer) {
        return menadzerRepository.save(menadzer);
    }

    public Artikal save(Artikal artikal) {
        return artikalRepository.save(artikal);
    }

    public String delete(Long id) {
        artikalRepository.deleteById(id);
        //if(!artikal) {
        //     Optional<Artikal> deletedArtikal = artikalRepository.delete(artikal);
        //   return deletedArtikal.orElse(null);
        // }
        return "Artikal je obrisan.";
    }

}


