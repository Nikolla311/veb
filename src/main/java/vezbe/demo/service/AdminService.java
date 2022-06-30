package vezbe.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import vezbe.demo.dto.MenadzerRestoranDto;
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


    public Restoran saveRestoran(Restoran restoran) {
        return restoranRepository.save(restoran);
    }

   /* public void updateMenadzerRestoran(Menadzer menadzer, Restoran restoran) {
        Optional<Menadzer> foundMenadzer = menadzerRepository.findByUsername(menadzer.getUsername());
        public void updateCustomerContacts(long id, String phone) {
            repo.updatePhone(id, phone);
        }
        menadzerRepository.save(foundMenadzer);
    }*/
   public boolean updateMenadzerRestoran(MenadzerRestoranDto dto) {
       Menadzer menadzer = menadzerRepository.findById(dto.getIdMenadzer()).get();
       Restoran restoran = restoranRepository.findById(dto.getIdRestoran()).get();
       if (restoran.getMenadzer() != null) {
           return false;
       }
       menadzer.setRestoran(restoran);
       menadzerRepository.save(menadzer);
       restoran.setMenadzer(menadzer);
       restoranRepository.save(restoran);
       return true;
   }
    public void saveUpdateIme(Long id, String ime) {
        Admin admin = adminRepository.findById(id).get();
        admin.setIme(ime);
        adminRepository.save(admin);
    }
    public void saveUpdateRestoranIme(Long id, String naziv) {
        Restoran restoran = restoranRepository.findById(id).get();
        restoran.setNazivRestorana(naziv);
        restoranRepository.save(restoran);
    }
    public void saveUpdateRestoranTip(Long id, String tip) {
        Restoran restoran = restoranRepository.findById(id).get();
        restoran.setTipRestorana(tip);
        restoranRepository.save(restoran);
    }
    public void saveUpdateRestoranLokacija(Long id, String adresa) {
        Restoran restoran = restoranRepository.findById(id).get();
        restoran.getLokacija().setAdresa(adresa);
        restoranRepository.save(restoran);
    }
    public Menadzer save(Menadzer menadzer){
        return menadzerRepository.save(menadzer);
    }
    public Dostavljac save(Dostavljac dostavljac){
        return dostavljacRepository.save(dostavljac);
    }
    public Admin save(Admin admin){
        return adminRepository.save(admin);
    }


}