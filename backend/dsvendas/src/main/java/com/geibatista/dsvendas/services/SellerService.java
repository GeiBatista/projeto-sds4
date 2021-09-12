package com.geibatista.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geibatista.dsvendas.dto.SellerDTO;
import com.geibatista.dsvendas.entities.Seller;
import com.geibatista.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {

	@Autowired
	private SellerRepository repository;
	
	public List<SellerDTO> findAll(){
		List<Seller> result =  repository.findAll();
		//Converter a lista de Seller para uma lista de SellerDTO
		//A função map converte a coleção original para uma nova coleção que pode inclusive ser de outro tipo
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	}
}
