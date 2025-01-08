package buffetAplicacion.Modelo;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="PAGOS")
@Data
public class Pago{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PAGO_ID")
	private Long id;

    private String formaPago;

    private Boolean Pagado;

    public Pago() {}
}
