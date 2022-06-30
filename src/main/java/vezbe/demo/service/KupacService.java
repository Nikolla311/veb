package vezbe.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vezbe.demo.model.Korisnik;
import vezbe.demo.model.Kupac;
import vezbe.demo.repository.KupacRepository;

@Service
public class KupacService {
    @Autowired
    KupacRepository kupacRepository;
    /*
    public Kupac findKupac(Korisnik korisni){
        Kupac kupac = kupacRepository.findByKorisnicko(korisni.getKorisnicko());
        return kupac;
    }*/

    public void saveKupac(Kupac kupac){
        kupacRepository.save(kupac);
    }

}
