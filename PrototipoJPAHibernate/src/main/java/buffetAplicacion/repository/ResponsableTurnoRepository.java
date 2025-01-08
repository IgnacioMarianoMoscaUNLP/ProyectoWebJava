package buffetAplicacion.repository;

import buffetAplicacion.Modelo.ResponsableTurno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResponsableTurnoRepository extends JpaRepository<ResponsableTurno, Long> {

    // Buscar un ResponsableTurno por su DNI
    ResponsableTurno findByDni(int dni);

    // Métodos CRUD básicos ya están incluidos, como save, findAll, deleteById, etc.
}
