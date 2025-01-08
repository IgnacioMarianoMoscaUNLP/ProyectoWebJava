package buffetAplicacion.services;

import java.util.Optional;

import buffetAplicacion.DTO.UsuarioDTO;
import buffetAplicacion.exceptions.InvalidCredentialsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import buffetAplicacion.Modelo.Usuario;
import buffetAplicacion.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private  UsuarioRepository usuarioRepository;
	@Autowired
	private ModelMapper modelMapper;

	public UsuarioDTO getUsuarioDTO(Usuario user) {
		return modelMapper.map(user, UsuarioDTO.class);
	}

	public Usuario getUsuario(UsuarioDTO userDTO) {
		return modelMapper.map(userDTO, Usuario.class);
	}

	public void saveUser(UsuarioDTO user) {
		Usuario user2 =  getUsuario(user);
		Optional<Usuario> busqueda = usuarioRepository.findUsuarioByDni(user2.getDni());
		System.out.println("llego al service");
		if(busqueda.isPresent()) throw new DataIntegrityViolationException("existe Usuario");
		System.out.println("no dio error");
		usuarioRepository.save(user2);
	}
	
	public Usuario recuperarUserClave(String clave, int dni) {
		System.out.println(123);
		Optional<Usuario> resultadoBusqueda = this.usuarioRepository.findUsuarioByDni(dni);
		if(resultadoBusqueda.isEmpty() ) {
			throw new InvalidCredentialsException("Sus credenciales son incorrectas");
		}else{
			if(!resultadoBusqueda.get().getClave().equals(clave)){
				throw new InvalidCredentialsException("Sus Credenciales son incorrectas");
			}else{
				return resultadoBusqueda.get();
			}
		}
	}


	public UsuarioDTO recuperar(int dni){
		Optional<Usuario> resultadoBusqueda = this.usuarioRepository.findUsuarioByDni(dni);
		resultadoBusqueda.orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));
		return  getUsuarioDTO(resultadoBusqueda.get());
	}

	public void actualizar(UsuarioDTO user,int dni) {
		Usuario user2 =  getUsuario(user);
		Optional<Usuario> resultadoBusqueda = this.usuarioRepository.findUsuarioByDni(user2.getDni());
		if(resultadoBusqueda.isEmpty()) throw new EntityNotFoundException("No existe Usuario");
		resultadoBusqueda.get().setClave(user2.getClave());
		resultadoBusqueda.get().setEmail(user2.getEmail());
		resultadoBusqueda.get().setApellido(user2.getApellido());
		resultadoBusqueda.get().setNombres(user2.getNombres());
		resultadoBusqueda.get().setFoto(user2.getFoto());
		this.usuarioRepository.save(resultadoBusqueda.get());
	}
}
