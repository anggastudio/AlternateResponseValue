package com.anggastudio;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseProduct{

	@SerializedName("product")
	private Product product;

	private List<Product> products;

	public void setProduct(Product product){
		this.product = product;
	}

	public Product getProduct(){
		return product;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}