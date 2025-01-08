package buffetAplicacion.controllers;

import buffetAplicacion.DTO.ComidaDTO;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import java.sql.SQLException;
import java.util.List;
import buffetAplicacion.services.ComidaService;
import buffetAplicacion.Modelo.Comida;
import buffetAplicacion.Modelo.Menu;
import jakarta.persistence.EntityNotFoundException;


@RestController
@RequestMapping(value = "/comida", produces =
MediaType.APPLICATION_JSON_VALUE)
public class ComidaRestController {

	@Autowired
	private ComidaService comidaService;

	@PostMapping
    public ResponseEntity<ComidaDTO> crearComida(@RequestBody ComidaDTO comida) {
        ComidaDTO nuevaComida = comidaService.crearComida(comida);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaComida);
    }
	
	@GetMapping
    public ResponseEntity<List<ComidaDTO>> listarComidas() {
        List<ComidaDTO> comidas = comidaService.listarComidas();
        System.out.println("llego a obtener la comidas y las deberia enviar");
        return ResponseEntity.ok(comidas);
    }
	
	@PutMapping
    public ResponseEntity<ComidaDTO> actualizarComida(@RequestBody ComidaDTO comida) {
        ComidaDTO comidaActualizada = comidaService.actualizarComida(comida);
        return ResponseEntity.ok(comidaActualizada);
    }
}
