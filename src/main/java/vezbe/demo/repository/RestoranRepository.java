package vezbe.demo.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import vezbe.demo.dto.*;
import vezbe.demo.model.*;

import java.util.*;

@Repository
public interface RestoranRepository  extends JpaRepository<Restoran, Long> {
    List<Restoran> findAllByNazivRestorana(String nazivRestorana);
    List<Restoran> findAllByTipRestorana(String tipRestorana);
    List<Restoran> findAllByLokacija(Lokacija lokacija);

}
