package inventory_s;

import java.util.ArrayList;
import java.util.List;

public class Product_catalog {

	public List<String> getProductCategories(){
		
		List<String> categories = new ArrayList<String>();
		categories.add("Book");
		categories.add("Music");
		categories.add("Movies");
		
		return categories;
		
	}
}
