package vezbe.demo.service;


import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import vezbe.demo.model.*;
import vezbe.demo.repository.*;

import java.util.List;
import java.util.Optional;

@Service
public class ArtikalService {

    @Autowired
    private ArtikalRepository artikalRepository;

    public Artikal findOne(Long id){
        Optional<Artikal> foundArtikal = artikalRepository.findById(id);
        if (foundArtikal.isPresent())
            return foundArtikal.get();

        return null;
    }

    public List<Artikal> findAll(){
        return artikalRepository.findAll();
    }

    public Artikal save(Artikal artikal){
        return artikalRepository.save(artikal);
    }
}