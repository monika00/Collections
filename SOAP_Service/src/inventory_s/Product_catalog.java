package inventory_s;


import java.util.List;

import javax.jws.WebService;

import buisness.Product_catalog_impl;

@WebService
public class Product_catalog {

	Product_catalog_impl productService = new Product_catalog_impl();
	
	public List<String> getProductCategories(){
		return productService.getProductCategories();
	}
	
	public List<String> getProducts(String category){
		return productService.getProducts(category);
	}
	
	public boolean addPruduct(String category, String product){
		return productService.addProductString(category, product);
	}
}
