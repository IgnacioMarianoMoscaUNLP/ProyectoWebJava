package buffetAplicacion.Modelo;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="COMIDAS")
@Data
@Setter
@Getter
public class Comida {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="COMIDA_ID")
	private Long id;

	@Column(name="nombre", unique = true, nullable = false)
	private String nombre;

	private Double precio;

	public Comida() {}
	
	public Comida(String nombre, Double precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}
}
