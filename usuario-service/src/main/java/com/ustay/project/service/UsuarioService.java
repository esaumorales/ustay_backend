package com.ustay.project.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ustay.project.entity.Usuario;
import com.ustay.project.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioService {
	@Autowired
	
	UsuarioRepository usuarioRepository;

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	public void save(Usuario usuario) {
		if (usuario.getFechaRegistro() == null) {
			usuario.setFechaRegistro(LocalDateTime.now());
		}
		usuarioRepository.save(usuario);
	}

	public Optional<Usuario> findById(int id) {
		return usuarioRepository.findById(id);
	}

	public void delete(int id) {
		usuarioRepository.deleteById(id);
	}

	public boolean existsById(int id) {
		return usuarioRepository.existsById(id);
	}

	public void update(int id, Usuario updatedUsuario) {
		Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
		if (optionalUsuario.isPresent()) {
			Usuario usuario = optionalUsuario.get();
			usuario.setNombre(updatedUsuario.getNombre());
			usuario.setApellido(updatedUsuario.getApellido());
			usuario.setCorreo(updatedUsuario.getCorreo());
			usuario.setContrasena(updatedUsuario.getContrasena());
			usuario.setFechaRegistro(updatedUsuario.getFechaRegistro());
			usuarioRepository.save(usuario);
		}
	}

	public boolean verifyUser(String correo, String contrasena) {
		// Busca al usuario por correo y contraseña
		Optional<Usuario> usuario = usuarioRepository.findByCorreoAndContrasena(correo, contrasena);
		return usuario.isPresent(); // Devuelve true si el usuario existe, false en caso contrario
	}
	
    public Optional<Usuario> findByCorreoAndContrasena(String correo, String contrasena) {
        return usuarioRepository.findByCorreoAndContrasena(correo, contrasena);
    }
}