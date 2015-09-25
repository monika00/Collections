package inventory_s;


import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import buisness.Product_catalog_impl;

@WebService
public class Product_catalog {

	Product_catalog_impl productService = new Product_catalog_impl();
	
	@WebMethod
	public List<String> getProductCategories(){
		return productService.getProductCategories();
	}
	
	@WebMethod(exclude=true)
	public List<String> getProducts(String category){
		return productService.getProducts(category);
	}
	
	@WebMethod(exclude=true)
	public boolean addPruduct(String category, String product){
		return productService.addProductString(category, product);
	}
}
