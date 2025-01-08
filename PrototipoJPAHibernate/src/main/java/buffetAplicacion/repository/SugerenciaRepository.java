package buffetAplicacion.repository;

import buffetAplicacion.Modelo.Sugerencia;
import buffetAplicacion.Modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SugerenciaRepository extends JpaRepository<Sugerencia, Long> {
/*
    // Buscar una sugerencia por usuario
    Sugerencia findByUsuario(Usuario usuario);

    // Eliminar todas las sugerencias asociadas a un usuario
    void deleteByUsuario(Usuario usuario);

    // Spring Data JPA ya incluye métodos como findAll(), save(), deleteById(), etc.
*/
}
