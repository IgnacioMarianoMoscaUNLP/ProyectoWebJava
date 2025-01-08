package buffetAplicacion.repository;

import buffetAplicacion.Modelo.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {

}
