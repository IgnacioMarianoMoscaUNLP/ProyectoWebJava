package buffetAplicacion.services;

import buffetAplicacion.DTO.MenuDTO;
import buffetAplicacion.DTO.UsuarioDTO;

import buffetAplicacion.Modelo.Usuario;
import jakarta.persistence.EntityExistsException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import buffetAplicacion.Modelo.Comida;
import buffetAplicacion.Modelo.Menu;
import buffetAplicacion.repository.MenuRepository;

@Service
@Transactional
public class MenuesService {

	@Autowired
	private MenuRepository menuRepository;

	@Autowired
	private ModelMapper modelMapper;

	public MenuDTO getMenuDTO(Menu menu) {
		return modelMapper.map(menu, MenuDTO.class);
	}

	public Menu getMenu(MenuDTO menuDTO) {
		return modelMapper.map(menuDTO, Menu.class);
	}
	@Autowired
	private ComidaService ComidaService;

	public MenuDTO crearMenu(MenuDTO menu) {

		if (menu.getComidas() == null || menu.getComidas().isEmpty()) {
	        throw new IllegalArgumentException("El menú debe tener al menos una comida asociada.");
	    }
		/* La logica se debe cambiar para que al menu se le asignen comidas que ya existen
		* por ende se pasan comidas que ya existen
		*
	    for (Comida comida : menu.getComidas()) {
	        this.ComidaService.guardarComida(comida);
	    }
		*/
		Menu menu2 = getMenu(menu);
		menu.setIdmenu(menuRepository.save(menu2).getIdmenu());
	    return menu;
	}

	public MenuDTO actualizarMenu(MenuDTO menu) {
			Optional<Menu> busqueda = this.menuRepository.findById(menu.getIdmenu());
			busqueda.orElseThrow( () -> new EntityExistsException("El id de menu no existe"));
			/* Mismo cambio de flujo que crear
			for (Comida comida : menu.getComidas()) {
				this.ComidaService.guardarComida(comida);
			}
			*/

			//Analizar que pasa si faltan campos
			Menu aux = getMenu(menu);
			busqueda.get().setTipo(aux.getTipo());
			busqueda.get().setPrecio(aux.getPrecio());
			busqueda.get().setComidas(menu.getComidas());
			busqueda.get().setDias(aux.getDias());
			menuRepository.save(busqueda.get());
			menu.setIdmenu(busqueda.get().getIdmenu());
			return menu;

	}

	public MenuDTO obtenerMenuPorId(Long id) {
		Optional<Menu> busqueda = this.menuRepository.findById(id);
		if(busqueda.isEmpty()) throw new EntityExistsException("El menu "+id+" no existe");
		return getMenuDTO(busqueda.get());
	}

	public List<MenuDTO> obtenerTodosLosMenus() {
		List<MenuDTO> nueva= new ArrayList<MenuDTO>();
		MenuDTO aux;
		List<Menu> menuList= menuRepository.findAll();
		for (Menu menu : menuList) {
			aux = getMenuDTO(menu);
			aux.setIdmenu(menu.getIdmenu());
			nueva.add(aux);
		}
		return nueva;
	}
}


