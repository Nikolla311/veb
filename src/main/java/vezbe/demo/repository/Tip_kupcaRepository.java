package vezbe.demo.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import vezbe.demo.model.*;
@Repository
public interface Tip_kupcaRepository  extends JpaRepository<Tip_kupca, Long> {
}
