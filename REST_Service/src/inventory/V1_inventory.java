package inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import org.codehaus.jettison.json.JSONArray;

import DAO.DataBaseCon;
import utility.ToJson;

@Path("V1/inventory")
public class V1_inventory {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnSQLData() throws Exception{
		
		PreparedStatement query = null;
		Connection conn = null;
		String returnString = null;
		Response res = null;
		
		try{
			conn = DataBaseCon.DBConn();
			query = conn.prepareStatement("select * from test.first");
			ResultSet rs = query.executeQuery();
			
			//java.sql.ResultSetMetaData rsmd = rs.getMetaData();
			
			ToJson converter = new ToJson();
			JSONArray json = new JSONArray();
			
			json = converter.toJSONArray(rs);
			query.close();
			
			returnString = json.toString();
			//returnString = rsmd.toString();
			
			res = Response.ok(returnString).build();
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(conn != null) conn.close();
		}
		
		return res;
	}

}
