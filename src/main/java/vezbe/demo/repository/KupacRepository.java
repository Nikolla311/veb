package vezbe.demo.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import vezbe.demo.model.*;

import java.util.Optional;

@Repository
public interface KupacRepository  extends JpaRepository<Kupac, Long> {

}
