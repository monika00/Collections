package inventory;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import DAO.DB_Schema;

@Path("V3/inventory")
public class V3_inventory {

	@POST
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED,
			MediaType.APPLICATION_JSON })
	// @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addSQLData2(String data) throws Exception {

		String returnString = null;
		DB_Schema schema = new DB_Schema();
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();

		try {

			JSONObject data1 = new JSONObject(data);

			int http_code = schema.queryInsertData(
					data1.optString("firstname"), 
					data1.optString("lastname"));

			if (http_code == 200) {
				/*
				 * The put method allows you to add data to a JSONObject. The
				 * first parameter is the KEY (no spaces) The second parameter
				 * is the Value
				 */
				jsonObject.put("HTTP_CODE", "200");
				jsonObject.put("MSG",
						"Item has been entered successfully, Version 3");
				/*
				 * When you are dealing with JSONArrays, the put method is used
				 * to add JSONObjects into JSONArray.
				 */
				returnString = jsonArray.put(jsonObject).toString();
			} else {
				return Response.status(500).entity("Unable to enter Item")
						.build();
			}

			System.out.println("returnString: " + returnString);

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500)
					.entity("Server was not able to process your request")
					.build();
		}

		return Response.ok(returnString).build();
	}
}
