package com.ustay.project.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ustay.project.entity.Partner;
import com.ustay.project.service.PartnerService;

@RestController
@RequestMapping("/partner")
public class PartnerController {

	@Autowired
	private PartnerService partnerService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Partner>> listar(){
		List<Partner> list = partnerService.listar();
		if (list.isEmpty()) {
            return new ResponseEntity<>(org.springframework.http.HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, org.springframework.http.HttpStatus.OK);
	}
	
	@PostMapping("/save")
    public ResponseEntity<?> save(
            @ModelAttribute Partner partner,
            @RequestParam("file") MultipartFile file) {
        try {
            // Procesa y guarda el edificio y la imagen
            partnerService.save(partner, file, file);
            return ResponseEntity.status(HttpStatus.CREATED).body("partnerguardado con éxito");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar el edificio");
        }
    }
	
}