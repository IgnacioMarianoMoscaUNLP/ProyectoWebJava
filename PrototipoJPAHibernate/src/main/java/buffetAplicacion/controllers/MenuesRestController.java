package buffetAplicacion.config;
import buffetAplicacion.DTO.MenuDTO;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import java.sql.SQLException;
import java.util.List;		
import buffetAplicacion.services.MenuesService;
import buffetAplicacion.Modelo.Menu;
import buffetAplicacion.Modelo.Usuario;
import jakarta.persistence.EntityNotFoundException;


@RestController
@RequestMapping(value = "/menu", produces =
MediaType.APPLICATION_JSON_VALUE)
public class MenuesRestController {
	@Autowired
	private MenuesService menuesService;
	 
	 @PostMapping
	    public ResponseEntity<MenuDTO> crearMenu(@RequestBody MenuDTO menu) {
	        MenuDTO nuevoMenu = menuesService.crearMenu(menu);
	        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoMenu);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<MenuDTO> actualizarMenu(@PathVariable("id") Long id, @RequestBody MenuDTO menu) {
	     	menu.setIdmenu(id);
		 	MenuDTO menuActualizado = menuesService.actualizarMenu(menu);
		 	return ResponseEntity.ok(menuActualizado);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<MenuDTO> obtenerMenuPorId(@PathVariable("id") Long id) {
	        MenuDTO menu = menuesService.obtenerMenuPorId(id);
			return ResponseEntity.ok(menu);
	    }

	    @GetMapping
	    public ResponseEntity<List<MenuDTO>> obtenerTodosLosMenus() {
	        List<MenuDTO> menus = menuesService.obtenerTodosLosMenus();
	        return ResponseEntity.ok(menus);
	    }
	
}
