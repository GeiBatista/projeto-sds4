package com.geibatista.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geibatista.dsvendas.dto.SellerDTO;
import com.geibatista.dsvendas.services.SellerService;

@RestController
@RequestMapping(value = "/sellers") //indica o caminho do recurso web
public class SellerController {
	
	@Autowired
	private SellerService service;
	
	//Método que representa o endpoint
	@GetMapping
	public ResponseEntity<List<SellerDTO>> findAll() {
		List<SellerDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}

}
