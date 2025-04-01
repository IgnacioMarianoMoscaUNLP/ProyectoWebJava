package buffetAplicacion.config;
import buffetAplicacion.Modelo.Comida;
import buffetAplicacion.Modelo.Menu;
import buffetAplicacion.Modelo.Usuario;
import buffetAplicacion.repository.ComidaRepository;
import buffetAplicacion.repository.MenuRepository;
import buffetAplicacion.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final MenuRepository menuRepository;
    private final ComidaRepository comidaRepository;
    private  final UsuarioRepository usuarioRepository;


    public DataLoader(MenuRepository menuRepository, ComidaRepository comidaRepository,UsuarioRepository usuarioRepository) {
        this.menuRepository = menuRepository;
        this.comidaRepository = comidaRepository;
        this.usuarioRepository = usuarioRepository;
    }
    public static Menu.Dias desdeDayOfWeek(DayOfWeek dayOfWeek) {
        return Menu.Dias.values()[dayOfWeek.getValue() - 1]; // DayOfWeek usa 1 para Lunes, 7 para Domingo
    }
    public enum Dias {
        LUNES, MARTES, MIERCOLES, JUEVES, VIERNES
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

            Usuario admin = new Usuario("admin",12345,"admin","admin@gmail.com",null,"654321");
            Usuario usuario2 = new Usuario("ignacio",123,"mariano","ignacio@gmail.com",null,"123456");
            Usuario usuario3 = new Usuario("nicolas",1234,"fernandez","nicolas@gmail.com",null,"123456");

            usuarioRepository.save(admin);
            usuarioRepository.save(usuario2);
            usuarioRepository.save(usuario3);


            Comida comida1 = new Comida("Milanesa",200.1);
            Comida comida2 = new Comida("Papas",200.2);
            Comida comida3 = new Comida("Tarta zapallo",200.3);
            Comida comida4 = new Comida("quesadilla",200.4);
            Comida comida5 = new Comida("pastel de carne",200.5);
            Comida comida6 = new Comida("Ensalda",200.6);

            comida1 = comidaRepository.save(comida1);
            comida2 = comidaRepository.save(comida2);

            comida3 = comidaRepository.save(comida3);
            comida4 = comidaRepository.save(comida4);

            comida5 = comidaRepository.save(comida5);

            comida6 = comidaRepository.save(comida6);

            Menu menuVegano = new Menu();
            Menu menuNoVegano = new Menu();
            Menu menu1 = new Menu();
            Menu menu2 = new Menu();

            LocalDate hoy = LocalDate.now();
            DayOfWeek dayOfWeek = hoy.getDayOfWeek();
            Menu.Dias diaEnum = desdeDayOfWeek(dayOfWeek);


            menuVegano.setDias(diaEnum);
            menuVegano.setTipo("Vegano");
            List<Long> comidasVegano = new ArrayList<Long>();
            comidasVegano.add(comida3.getId());
            comidasVegano.add(comida4.getId());
            menuVegano.setComidas(comidasVegano);
            menuVegano.setPrecio(400.0);


            menuNoVegano.setDias(diaEnum);
            menuNoVegano.setTipo("No Vegano");
            List<Long> comidasNoVegano = new ArrayList<Long>();
            comidasNoVegano.add(comida1.getId());
            comidasNoVegano.add(comida2.getId());
            menuNoVegano.setComidas(comidasNoVegano);
            menuNoVegano.setPrecio(400.0);

            menu1.setPrecio(200.0);
            menu1.setTipo("Vegano");
            List<Long> comidas1 = new ArrayList<Long>();
            comidas1.add(comida5.getId());
            menu1.setComidas(comidas1);
            menu1.setDias(Menu.Dias.JUEVES);

            menu2.setPrecio(200.0);
            menu2.setTipo("NO Vegano");
            List<Long> comidas2 = new ArrayList<Long>();
            comidas2.add(comida6.getId());
            menu2.setComidas(comidas2);
            menu2.setDias(Menu.Dias.LUNES);

        menuRepository.save(menuVegano);
        menuRepository.save(menuNoVegano);
        menuRepository.save(menu1);
        menuRepository.save(menu2);
    }
}
