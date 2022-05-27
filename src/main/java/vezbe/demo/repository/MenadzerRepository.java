package vezbe.demo.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import vezbe.demo.model.*;

import java.util.*;

@Repository
public interface MenadzerRepository  extends JpaRepository<Menadzer, Long> {
    Optional<Menadzer> findByUsername(String username);
}
