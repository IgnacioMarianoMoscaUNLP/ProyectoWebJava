package buffetAplicacion.Modelo;
import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PEDIDOS")
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PEDIDO_ID")
    private Long id;

    private String codigoQR;

    private Double costeTotal;

    @ManyToMany
    @JoinTable(
            name = "pedidos_comidas",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "comida_id"))
    private List<Comida> comidas;

    @OneToOne
    @JoinColumn(name = "PEDIDO_ID")
    private Usuario comprador;

    @ManyToMany
    @JoinTable(
            name = "pedidos_menues",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_id"))
    private List<Menu> menues;

    @OneToOne
    @JoinColumn(name = "PEDIDO_ID")
    private Pago pago; // Cambiar Long a la entidad correspondiente, por ejemplo Pago

    public Pedido() {}

    public int getCantidadMenu() {
        return menues != null ? menues.size() : 0;
    }
}
