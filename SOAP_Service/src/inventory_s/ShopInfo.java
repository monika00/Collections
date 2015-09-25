package inventory_s;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class ShopInfo {
	
	@WebMethod
	public String getShopInfo(String property){
		String response = "Invalid property";
		if("shopName".equals(property)){
			response = "Parduotuvë";
		}
		if("since".equals(property)){
			response = "since 2015";
		}
		return response;
	}
}
