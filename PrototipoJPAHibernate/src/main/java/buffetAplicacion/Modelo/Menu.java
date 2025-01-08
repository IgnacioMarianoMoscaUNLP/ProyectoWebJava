package buffetAplicacion.Modelo;
import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="MENUES")
@Data
@Getter
@Setter
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MENU_ID")
	private Long idmenu;

	private Double precio;

	private String tipo;


	/*
	* Ver que directamente guarde el id de comida
	* ya que en la api podemos pasar lista de id comida
	* "comida":[1,2,3,4]
	*
	@ManyToMany
	@JoinTable(
		name = "menues_comidas",
		joinColumns = @JoinColumn(name = "menu_id"),
		inverseJoinColumns = @JoinColumn(name = "comida_id"))
	*/
	private List<Long> comidas;


	@Enumerated(EnumType.STRING)  // O EnumType.ORDINAL
	private Dias dias;

	public Menu() {}

	public enum Dias {
	    LUNES, MARTES, MIERCOLES, JUEVES, VIERNES
	}

	public String getDetalle() {
		return null; //debería devolver un detalle con todo
	}
}
