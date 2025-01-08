package buffetAplicacion.Modelo;
import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "USUARIOS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_responsable")
@Data
public class Usuario {

	@Id
	@Column(name = "dni")
	private int dni;

    private String apellido;

    private String nombres;

    private String email;

    @Lob


    @Column(name = "foto", columnDefinition = "BLOB")
    private byte[] foto;  // Cambiado a byte[] para almacenar como BLOB

    private String clave;

    public Usuario() {}

	public Usuario(String apellido, int dni, String nombres, String email, byte[] foto, String clave) {
        this.apellido = apellido;
        this.dni = dni;
        this.nombres = nombres;
        this.email = email;
        this.foto = foto;
        this.clave = clave;
    }
}
