package vezbe.demo.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import vezbe.demo.dto.ArtikalUpdateDto;
import vezbe.demo.model.*;
import vezbe.demo.repository.*;

import java.util.*;

@Service
public class MenadzerService {
    @Autowired
    private MenadzerRepository menadzerRepository;
    @Autowired
    private RestoranRepository restoranRepository;
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
    public Artikal findArtikal(Long id) {
        Optional<Artikal> foundArtikal = artikalRepository.findById(id);
        return foundArtikal.orElse(null);
    }

    public Artikal findId(Long id) {
        Optional<Artikal> foundArtikal = artikalRepository.findById(id);
        return foundArtikal.orElse(null);
    }

    public void updateArtikal(ArtikalUpdateDto dto) {
        Artikal artikal = artikalRepository.findById(dto.getId()).get();
        if (dto.getNaziv() != null) {
            artikal.setNaziv(dto.getNaziv());
        }
        if (dto.getTip_artikla() != null) {
            artikal.setTip_artikla(dto.getTip_artikla());
        }
        if (dto.getCena() != 0) {
            artikal.setCena(dto.getCena());
        }
        if (dto.getKolicina() != 0) {
            artikal.setKolicina(dto.getKolicina());
        }
        if (dto.getOpis() != null) {
            artikal.setOpis(dto.getOpis());
        }
        artikalRepository.save(artikal);
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

    public void delete(Long id) {
        artikalRepository.deleteById(id);
    }

}


