package com.ustay.project.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ustay.project.entity.Usuario;
import com.ustay.project.service.UsuarioService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/apiusuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/lista")
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> list = usuarioService.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable int id) {
        Optional<Usuario> usuario = usuarioService.findById(id);
        return usuario.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/verify")
    public ResponseEntity<Boolean> verifyUser(@RequestBody Map<String, String> credentials) {
        String correo = credentials.get("correo");
        String contrasena = credentials.get("contrasena");

        // Llama al servicio para verificar las credenciales
        boolean isValidUser = usuarioService.verifyUser(correo, contrasena);

        // Devuelve la respuesta con el valor booleano
        return new ResponseEntity<>(isValidUser, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Usuario usuario) {
        try {
            usuarioService.save(usuario);
            return new ResponseEntity<>("Usuario guardado exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Usuario usuario) {
        try {
            if (!usuarioService.existsById(id)) {
                return new ResponseEntity<>("No existe el usuario", HttpStatus.NOT_FOUND);
            }
            usuarioService.update(id, usuario);
            return new ResponseEntity<>("Usuario Actualizado", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        try {
            if (!usuarioService.existsById(id)) {
                return new ResponseEntity<>("No existe el usuario", HttpStatus.NOT_FOUND);
            }
            usuarioService.delete(id);
            return new ResponseEntity<>("Usuario eliminado", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String correo = credentials.get("correo");
        String contrasena = credentials.get("contrasena");

        // Llamar al servicio para buscar el usuario
        Optional<Usuario> usuario = usuarioService.findByCorreoAndContrasena(correo, contrasena);

        if (usuario.isPresent()) {
            // Si el usuario existe, devolver los datos del usuario
            return new ResponseEntity<>(usuario.get(), HttpStatus.OK);
        } else {
            // Si no existe, devolver error 401 (Unauthorized)
            return new ResponseEntity<>("Credenciales inválidas", HttpStatus.UNAUTHORIZED);
        }
    }
}
