package vezbe.demo.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import vezbe.demo.model.*;

import java.util.Optional;

@Repository
public interface ArtikalRepository  extends JpaRepository<Artikal, Long> {
    Optional<Artikal> findByNaziv(String naziv);
}
