package buffetAplicacion.repository;

import buffetAplicacion.Modelo.Comida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ComidaRepository extends JpaRepository<Comida, Long> {
    Optional<Comida> findByNombre(String nombre); // Spring Data JPA generará automáticamente la consulta.
    void deleteByNombre(String nombre); // Para eliminar por nombre.
}
