package vezbe.demo.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import vezbe.demo.model.*;

import java.util.*;

@Repository
public interface KorisnikRepository  extends JpaRepository<Korisnik, Long> {
    Korisnik getByUsername(String username);
    Optional<Korisnik> findByUsername(String username);
}

