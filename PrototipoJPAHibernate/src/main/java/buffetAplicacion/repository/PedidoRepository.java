package buffetAplicacion.repository;

import buffetAplicacion.Modelo.Pedido;
import buffetAplicacion.Modelo.Usuario;
import buffetAplicacion.Modelo.Comida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
 /*
    // Buscar pedido por código QR
    Pedido findByCodigoQR(String codigoQR);

    // Buscar pedidos por usuario
    List<Pedido> findByComprador(Usuario comprador);

    // Buscar pedidos por fecha
    List<Pedido> findByFecha(Date fecha);

    // Buscar pedidos que incluyan una comida específica
    @Query("SELECT p FROM Pedido p JOIN p.comidas c WHERE c = :comida")
    List<Pedido> findByComida(@Param("comida") Comida comida);

    // Buscar pedidos con monto total mayor a un valor dado
    @Query("SELECT p FROM Pedido p WHERE p.monto > :monto")
    List<Pedido> findByMontoMayorA(@Param("monto") Double monto);
*/
}
