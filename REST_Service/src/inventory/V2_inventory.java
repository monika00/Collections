package inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;

import utility.ToJson;
import DAO.DB_Schema;;

@Path("V2/inventory")
public class V2_inventory {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnSQLData(@QueryParam("firstname") String firstname) throws Exception{
		
		String returnString = null;
		JSONArray json = new JSONArray();

		
		try{
			
			if(firstname==null){
				return Response.status(400).entity("Error, please enter name parameter").build();
			}
			
			DB_Schema schema = new DB_Schema();
			json = schema.queryReturnData(firstname);
			returnString = json.toString();
			
		}
		
		catch(Exception e){
			e.printStackTrace();
			return Response.status(500).entity("Server was not able to process your request").build();
		}
		
		return Response.ok(returnString).build();
	} //Example @QueryParam wit error response 
	
	
	/*@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnError(){
		return Response.status(400).entity("Error, specify brand for this search").build();
	}*/
	
	
	@Path("/{firstname}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnSQLDataP(@PathParam("firstname") String firstname) throws Exception{
		
		String returnString = null;
		JSONArray json = new JSONArray();

		
		try{
			
			if(firstname==null){
				return Response.status(400).entity("Error, please enter name parameter").build();
			}
			
			DB_Schema schema = new DB_Schema();
			json = schema.queryReturnData(firstname);
			returnString = json.toString();
			
		}
		
		catch(Exception e){
			e.printStackTrace();
			return Response.status(500).entity("Server was not able to process your request").build();
		}
		
		return Response.ok(returnString).build();
	}


}
