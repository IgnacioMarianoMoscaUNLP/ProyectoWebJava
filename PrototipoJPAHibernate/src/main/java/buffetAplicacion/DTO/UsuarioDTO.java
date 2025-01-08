package buffetAplicacion.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsuarioDTO{

    private int dni;

    private String apellido;
    private String nombres;
    private String email;
    private byte[] foto;  // Cambiado a byte[] para almacenar como BLOB
    private String clave;


    public UsuarioDTO() {
    }

    public  UsuarioDTO(int dni, String apellido, String nombres, String email, byte[] foto, String clave) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombres = nombres;
        this.email = email;
        this.foto = foto;
        this.clave = clave;
    }

}
