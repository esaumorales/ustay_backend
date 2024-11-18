package com.ustay.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ustay.project.entity.Especificaciones;
import com.ustay.project.service.EspecificacionesService;

@RestController
@RequestMapping("/especificacion")
public class EspecificacionesController {

	@Autowired
	private EspecificacionesService especificacionService;

	@GetMapping("/listar")
	public ResponseEntity<List<Especificaciones>> listar() {
		List<Especificaciones> list = especificacionService.listar();
		if (list.isEmpty()) {
			return new ResponseEntity<>(org.springframework.http.HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(list, org.springframework.http.HttpStatus.OK);
	}
}