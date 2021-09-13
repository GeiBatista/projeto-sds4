package com.geibatista.dsvendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.geibatista.dsvendas.dto.SaleDTO;
import com.geibatista.dsvendas.entities.Sale;
import com.geibatista.dsvendas.repositories.SaleRepository;
import com.geibatista.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository; 
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){
		sellerRepository.findAll();
		Page<Sale> result =  repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	
//	public List<SaleDTO> findAll(){
//		List<Sale> result =  repository.findAll();
//		//Converter a lista de Seller para uma lista de SellerDTO
//		//A função map converte a coleção original para uma nova coleção que pode inclusive ser de outro tipo
//		return result.stream().map(x -> new SaleDTO(x)).collect(Collectors.toList());
//	}
}
