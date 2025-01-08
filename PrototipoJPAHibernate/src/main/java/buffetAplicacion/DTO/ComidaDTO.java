package buffetAplicacion.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComidaDTO {
    private Long id;
    private String nombre;
    private Double precio;

    public ComidaDTO() {
    }
}
