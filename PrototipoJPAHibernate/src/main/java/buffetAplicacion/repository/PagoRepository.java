package buffetAplicacion.repository;

import buffetAplicacion.Modelo.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PagoRepository extends JpaRepository<Pago, Long> {
    // Método personalizado para encontrar por código QR
  /*  Optional<Pago> findByCodigoQR(String codigoQR);*/
}
