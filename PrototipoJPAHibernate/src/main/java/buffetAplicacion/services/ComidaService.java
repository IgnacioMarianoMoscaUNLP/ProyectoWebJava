package buffetAplicacion.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import buffetAplicacion.DTO.ComidaDTO;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import buffetAplicacion.repository.ComidaRepository;
import buffetAplicacion.Modelo.Comida;
import buffetAplicacion.Modelo.Menu;
import buffetAplicacion.Modelo.Usuario;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ComidaService {

	@Autowired
	private ComidaRepository comidaRepository;

	@Autowired
	private ModelMapper modelMapper;


	public ComidaDTO crearComida(ComidaDTO comida) {
		Optional<Comida> busqueda = comidaRepository.findByNombre(comida.getNombre());
		if(busqueda.isPresent()) throw new EntityExistsException("La comida ya existe");
		Comida comida1 = modelMapper.map(comida, Comida.class);
		comidaRepository.save(comida1);
		comida.setId(comida1.getId());
		return comida;
	}

	public void guardarComida(ComidaDTO comida) {
		Optional<Comida> busqueda = comidaRepository.findByNombre(comida.getNombre());
		if(busqueda.isEmpty()){
			Comida comida1 = modelMapper.map(comida,Comida.class);
			this.comidaRepository.save(comida1);
		}
	}

	public List<ComidaDTO> listarComidas() {
		List<Comida> lista = this.comidaRepository.findAll();
		List<ComidaDTO> listaDto = new ArrayList<ComidaDTO>();
		for(Comida comida : lista){
			listaDto.add(modelMapper.map(comida,ComidaDTO.class));
		}
		return listaDto;
	}
	
	public ComidaDTO actualizarComida(ComidaDTO comida) {
		Optional<Comida> busqueda = comidaRepository.findByNombre(comida.getNombre());
		if (busqueda.isPresent()) {
			busqueda.get().setPrecio(comida.getPrecio());
			comidaRepository.save(busqueda.get());
			comida.setPrecio(busqueda.get().getPrecio());
			comida.setId(busqueda.get().getId());
			return comida;
		}
		throw new EntityNotFoundException("La comida no existe");
	}
}
