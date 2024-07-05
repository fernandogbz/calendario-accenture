package com.javiersalinas.servicios;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.javiersalinas.modelos.Usuario;
import com.javiersalinas.repositorios.RepositorioUsuario;

@Service
public class ServicioUsuario {

	@Autowired
	private final RepositorioUsuario resRepositorioUsuario;
	
	public ServicioUsuario(RepositorioUsuario resRepositorioUsuario) {
		this.resRepositorioUsuario = resRepositorioUsuario;
	}
	
	public BindingResult validarRegistro(BindingResult validaciones, Usuario usuario) {
		
		if(! usuario.getContraseña().equals(usuario.getConfirmarContraseña())) {
			validaciones.rejectValue("confirmarContraseña", "NoCoinciden", "Las contraseñas no coinciden.");
		}
		
		if(this.obtenerPorCorreo(usuario) != null) {
			validaciones.rejectValue("correo", "Existente", "Este correo ya está en uso!");
		}
		
		return validaciones;
	}
	
	public Usuario insertarUsuario(Usuario usuario) {
		String contraseñaEncriptada = BCrypt.hashpw(usuario.getContraseña(), BCrypt.gensalt());
		usuario.setContraseña(contraseñaEncriptada);
		return this.resRepositorioUsuario.save(usuario);
	}
	
	public Usuario obtenerPorCorreo(Usuario usuario) {
		return this.resRepositorioUsuario.getByCorreo(usuario.getCorreo());
	}
}
