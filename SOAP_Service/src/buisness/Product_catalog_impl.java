package buisness;

import java.util.ArrayList;
import java.util.List;




public class Product_catalog_impl {
	
	List<String> bookList = new ArrayList<String>();
	List<String> musicList = new ArrayList<String>();
	List<String> movieList = new ArrayList<String>();
	
	public Product_catalog_impl(){
		
		bookList.add("Poteris");
		bookList.add("Saulëlydis");
		bookList.add("Pasakos");
		
		musicList.add("RHCP");
		musicList.add("Coldplay");
		musicList.add("Pearl Jam");
		
		movieList.add("Titanic");
		movieList.add("Pulp Fiction");
		movieList.add("Fight club");
		
	}
	
	public List<String> getProductCategories(){
		
		List<String> categories = new ArrayList<String>();
		categories.add("Books");
		categories.add("Music");
		categories.add("Movies");
		
		return categories;
		
	}
	
	public List<String> getProducts(String category){
		
		switch(category.toLowerCase()){
		case "books":
			return bookList;
		case "music":
			return musicList;
		case "movies":
			return movieList;
		}
		
		return null;
	}
	
	public boolean addProductString(String category, String product){
		switch(category.toLowerCase()){
		case "books":
			bookList.add(product);
			break;
		case "music":
			musicList.add(product);
			break;
		case "movies":
			movieList.add(product);
			break;
		default:
			return false;
		}
		return true;
	}
		

}
