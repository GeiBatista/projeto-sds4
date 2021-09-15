package com.geibatista.dsvendas.dto;

import java.io.Serializable;

import com.geibatista.dsvendas.entities.Seller;

public class SaleSuccessDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String sellerName;
	private Long sum;
	private Long deals;

	 public SaleSuccessDTO() {
	}

	public SaleSuccessDTO(Seller seller, Long sum, Long deals) {
		sellerName = seller.getName();
		this.sum = sum;
		this.deals = deals;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public Long getSum() {
		return sum;
	}

	public void setSum(Long sum) {
		this.sum = sum;
	}

	public Long getDeals() {
		return deals;
	}

	public void setDeals(Long deals) {
		this.deals = deals;
	}	 
}
