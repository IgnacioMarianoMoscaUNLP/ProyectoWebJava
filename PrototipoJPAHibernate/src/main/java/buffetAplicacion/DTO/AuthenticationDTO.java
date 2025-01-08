package buffetAplicacion.DTO;

public class AuthenticationDTO {
    private int dni;
    private String clave;

    public AuthenticationDTO(String clave, int dni) {
        this.clave = clave;
        this.dni = dni;
    }

    public AuthenticationDTO() {}

    // Getters y setters
    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
