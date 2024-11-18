package com.ustay.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ustay.project.entity.Especificaciones;
import com.ustay.project.repository.EspecificacionesRepository;

@Service
public class EspecificacionesService {

	@Autowired
	private EspecificacionesRepository especificacionRepository;

	public List<Especificaciones> listar() {
		return especificacionRepository.findAll();
	}

}
