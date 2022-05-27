package vezbe.demo.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import vezbe.demo.model.*;
import vezbe.demo.repository.*;

import java.util.*;

@Service
public class RestoranService {
    @Autowired
    private RestoranRepository restoranRepository;

    public Restoran findOne(Long id){
        Optional<Restoran> foundRestoran = restoranRepository.findById(id);
        if (foundRestoran.isPresent())
            return foundRestoran.get();

        return null;
    }
    public List<Restoran> findNaziv(String nazivRestorana){
        List<Restoran> foundRestorani = restoranRepository.findAllByNazivRestorana(nazivRestorana);
        /*if (foundRestoran.isPresent())
            return foundRestoran.get();

        return null;
        */
         return foundRestorani;
    }
    public List<Restoran> findTip(String tipRestorana){
        List<Restoran> foundRestorani = restoranRepository.findAllByTipRestorana(tipRestorana);
        /*if (foundRestoran.isPresent())
            return foundRestoran.get();

        return null;*/
        return foundRestorani;
    }
    public List<Restoran> findLokacija(String adresa){

        List<Restoran> restorani = restoranRepository.findAll();
        List<Restoran> foundRestorani = new ArrayList<>();
        for (Restoran restoran : restorani) {
            if (restoran.getLokacija().getAdresa().equals(adresa)) {
                Restoran restoranNew = new Restoran(restoran.getId(), restoran.getNazivRestorana(), restoran.getTipRestorana(), restoran.getLokacija());
                foundRestorani.add(restoranNew);
            }
        }
        return foundRestorani;

    }
    public List<Restoran> findAll(){
        return restoranRepository.findAll();
    }

    public Restoran save(Restoran restoran){
        return restoranRepository.save(restoran);
    }

    /*public Korisnik addRestoran(Long employeeId, Long projectId) {
        Restoran restoran = restoranRepository.getById(employeeId);
        Restoran restoran = projectService.findById(projectId);
        if(project == null)
            return null;
        employee.getProjects().add(project);
        return employeeRepository.save(employee);
    }*/
}
