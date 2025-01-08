package buffetAplicacion.Modelo;
import jakarta.persistence.*;
import lombok.*;

@Entity
@DiscriminatorValue("turno")
@Data
public class ResponsableTurno extends Usuario {

	private String turnos;

	public ResponsableTurno() {	}
	
	public ResponsableTurno(String apellido, int dni, String nombres, String email, byte[] foto, String clave, String turnos) {
		super(apellido, dni, nombres, email, foto, clave);
		this.turnos = turnos;
	}
}
