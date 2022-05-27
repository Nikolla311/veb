package vezbe.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vezbe.demo.dto.RestoranDto;
import vezbe.demo.model.*;
import vezbe.demo.repository.PorudzbinaRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Service
public class PorudzbinaService {


    @Autowired
    private PorudzbinaRepository porudzbinaRepository;

    public List<Porudzbina> findIspravne(Long id){
        List<Porudzbina> sve = porudzbinaRepository.findAll();
        List<Porudzbina> ispravne = new ArrayList<>();
        for(Porudzbina p:sve) {
            if ( p.getKupac().getId() == id)
                ispravne.add(p);
        }
        return ispravne;
    }


    public List<Porudzbina> findAll(){
        return porudzbinaRepository.findAll();
    }

    public List<Porudzbina> findDostavljac(Korisnik korisnik){
        List<Porudzbina> svePorudzbine = porudzbinaRepository.findAll();
        List<Porudzbina> ispravneDostavljac = new ArrayList<>();
        for(Porudzbina porudzbina: svePorudzbine){
            if(porudzbina.getDostavljac() == korisnik || porudzbina.getStatus().equals(Status.CEKA_DOSTAVLJACA) ) {
                ispravneDostavljac.add(porudzbina);
            }
        }
        return ispravneDostavljac;
    }


    public List<Porudzbina> findMenadzer(Korisnik korisnik){
        List<Porudzbina> svePorudzbine = porudzbinaRepository.findAll();
        List<Porudzbina> ispravneMenadzer = new ArrayList<>();
        for(Porudzbina porudzbina: svePorudzbine){
            if(porudzbina.getRestoran().getMenadzer() == korisnik) {
                ispravneMenadzer.add(porudzbina);
            }
        }
        return ispravneMenadzer;
    }
/*

    public String purchaseMade(Set<Stavka> stavke, RestoranDto restoranDto, LocalDateTime datum, float cena, Korisnik kupac ){
        Kupac kupacl = KupacService.findKupac(kupac);
        Restoran restoran = RestoranService.findNaziv(RestoranDto.get);
        if(kupacl == null || restoran == null){
            return "Doslo je do greske!";
        }
        Porudzbina porudzbina = new Porudzbina(stavke, restoran, datum , cena, kupacl);
        porudzbinaRepository.save(porudzbina);
        return "Uspesno odradjeno!";
    }

    public String odobriPorudzbinu(Long id){
        Porudzbina porudzbina = porudzbinaRepository.getById(id);
        if(porudzbina == null){
            return "Nije validna porudzbina";
        }
        porudzbina.setStatus(Status.U_PRIPREMI);
        porudzbinaRepository.save(porudzbina);
        return "Uspesno izvrseno!";
    }

    public String posaljiPorudzbinu(Long id){
        Porudzbina porudzbina = porudzbinaRepository.getById(id);
        if(porudzbina == null){
            return "Nije validna porudzbina";
        }
        porudzbina.setStatus(Status.CEKA_DOSTAVLJACA);
        porudzbinaRepository.save(porudzbina);
        return "Uspesno izvrseno!";
    }

    public String preuzmi(Long id){
        Porudzbina porudzbina = porudzbinaRepository.getById(id);
        if(porudzbina == null){
            return "Nije validna porudzbina";
        }
        porudzbina.setStatus(Status.U_TRANSPORTU);
        porudzbinaRepository.save(porudzbina);
        return "Uspesno izvrseno!";
    }

    public String dostavi(Long id){
        Porudzbina porudzbina = porudzbinaRepository.getById(id);
        if(porudzbina == null){
            return "Nije validna porudzbina";
        }
        porudzbina.setStatus(Status.DOSTAVLJENA);
        Kupac kupac = porudzbina.getKupac();
        int bodovi = kupac.getBr_sakupljenih_bodova();
        bodovi += (porudzbina.getCena()/1000)*133;
        kupac.setBr_sakupljenih_bodova(bodovi);
        kupacService.saveKupc(kupac);
        porudzbinaRepository.save(porudzbina);
        return "Uspesno izvrseno!";
    }
    */

}
