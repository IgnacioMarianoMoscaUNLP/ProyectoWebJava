package buffetAplicacion.Modelo;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="SUGERENCIAS")
@Data
public class Sugerencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SUGERENCIA_ID")
	private Long id;

	@OneToOne@JoinColumn(name="SUGERENCIA_ID")
	private Usuario usuario;

	private String mensaje;

	private String tipo;

	public Sugerencia() {}
}
