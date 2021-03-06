package com.geibatista.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geibatista.dsvendas.dto.SaleDTO;
import com.geibatista.dsvendas.dto.SaleSuccessDTO;
import com.geibatista.dsvendas.dto.SaleSumDTO;
import com.geibatista.dsvendas.services.SaleService;

@RestController
@RequestMapping(value = "/sales") //indica o caminho do recurso web
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	//Método que representa o endpoint
	// parametros possíveis sales?page=1&size=10&sort=date,desc
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
		Page<SaleDTO> list = service.findAll(pageable);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/amount-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller() {
		List<SaleSumDTO> list = service.amountGroupedBySeller();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/success-by-seller")
	public ResponseEntity<List<SaleSuccessDTO>> successGroupedBySeller() {
		List<SaleSuccessDTO> list = service.successGroupedBySeller();
		return ResponseEntity.ok(list);
	}

}
