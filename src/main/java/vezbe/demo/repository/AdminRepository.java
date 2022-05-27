package vezbe.demo.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import vezbe.demo.model.*;

import java.util.*;

@Repository
public interface AdminRepository  extends JpaRepository<Admin, Long> {
    Optional<Admin> findByUsername(String username);
}