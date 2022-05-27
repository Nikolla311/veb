package vezbe.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import vezbe.demo.model.*;

import vezbe.demo.repository.*;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private RestoranRepository restoranRepository;

    @Autowired
    private MenadzerRepository menadzerRepository;

    @Autowired
    private DostavljacRepository dostavljacRepository;

   /* @Autowired
    private RestoranRepository restoranRepository;*/



    public Admin findOne(String username){
        Optional<Admin> foundAdmin = adminRepository.findByUsername(username);
        return foundAdmin.orElse(null);
    }
    public Restoran findRestoran(Long id){
        Optional<Restoran> foundRestoran = restoranRepository.findById(id);
        return foundRestoran.orElse(null);
    }
    public Menadzer findMenadzer(Long id){
        Optional<Menadzer> foundMenadzer = menadzerRepository.findById(id);
        return foundMenadzer.orElse(null);
    }

    public Menadzer save(Menadzer menadzer){
        return menadzerRepository.save(menadzer);
    }
    public Dostavljac save(Dostavljac dostavljac){
        return dostavljacRepository.save(dostavljac);
    }


}