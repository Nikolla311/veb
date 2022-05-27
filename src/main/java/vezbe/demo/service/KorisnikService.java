package vezbe.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import vezbe.demo.model.*;

import vezbe.demo.repository.*;

import java.util.List;
import java.util.Optional;

@Service
public class KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;

    @Autowired
    private RestoranService restoranService;

    /*public Korisnik findOne(Long id){
        Optional<Korisnik> foundKorisnik = korisnikRepository.findById(id);
        return foundKorisnik.orElse(null);
    }*/
    public Korisnik findOne(String username){
        Optional<Korisnik> foundKorisnik = korisnikRepository.findByUsername(username);
        return foundKorisnik.orElse(null);
    }

    public List<Korisnik> findAll(){
        return korisnikRepository.findAll();
    }

    public Korisnik save(Korisnik korisnik){
        return korisnikRepository.save(korisnik);
    }

    public Korisnik login(String username, String lozinka) {
        Korisnik korisnik = korisnikRepository.getByUsername(username);
        if(korisnik == null || !korisnik.getLozinka().equals(lozinka))
            return null;
        return  korisnik;
    }

    /*public Korisnik addProject(Long employeeId, Long projectId) {
        Employee employee = employeeRepository.getById(employeeId);
        Project project = projectService.findById(projectId);
        if(project == null)
            return null;
        employee.getProjects().add(project);
        return employeeRepository.save(employee);
    }*/

}
