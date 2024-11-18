package com.ustay.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ustay.project.entity.Servicios;
import com.ustay.project.repository.ServiciosRepository;

@Service
public class ServiciosService {

	@Autowired
	private ServiciosRepository serviciosRepository;
	
	public List<Servicios> listar(){
		return serviciosRepository.findAll();
	}
	
	public List<Servicios> listByInmueble(int inmuebleId){
        return serviciosRepository.findByInmuebleId(inmuebleId);
	}
	
}
