package inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	
	@Path("/{firstname}/{lastname}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnSQLDataSpecific(@PathParam("firstname") String firstname, @PathParam("lastname") String lastname) throws Exception{
		
		String returnString = null;
		JSONArray json = new JSONArray();
		
		try{
			
			if(firstname==null){
				return Response.status(400).entity("Error, please enter name parameter").build();
			}
			
			DB_Schema schema = new DB_Schema();
			json = schema.queryReturnDataSpecific(firstname, lastname);
			returnString = json.toString();	
		}
		
		catch(Exception e){
			e.printStackTrace();
			return Response.status(500).entity("Server was not able to process your request").build();
		}
		
		return Response.ok(returnString).build();
	}
	
	@POST
	//@Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON})
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addSQLData(String data) throws Exception{
		
		String returnString = null;
		DB_Schema schema = new DB_Schema();
		
		try{
			
			System.out.println("IncomingData" + data);
			
			ObjectMapper mapper = new ObjectMapper();
			SQLEntry entry = mapper.readValue(data, SQLEntry.class);
			
			int http_code = schema.queryInsertData(entry.firstname, entry.lastname);
			
			if(http_code==200){
				returnString="Data inserted";
			}else{
				return Response.status(500).entity("Unable to proccess request").build();
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
			return Response.status(500).entity("Unable to proccess request").build();
		}
	
		return Response.ok(returnString).build();
	}
}

class SQLEntry{
	public String firstname;
	public String lastname;
}
