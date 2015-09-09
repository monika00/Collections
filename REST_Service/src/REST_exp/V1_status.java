package REST_exp;


import javax.ws.rs.*;
import javax.ws.rs.core.*;

import java.sql.*;
import java.util.ArrayList;

import DAO.DataBaseCon;


@Path("/V1/status")
public class V1_status {
	
	private static final String Version = "1.0";

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnTitle(){
		return "<p>Java Web Service</p>";
	}
	
	@Path("/version")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnVerion(){
		return "<p>Version:</p> " + Version;
	}
	
	
	@Path("/database")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnDatabaseStatus() throws Exception{
		
		PreparedStatement query = null;
		ArrayList<String> myString = new ArrayList<String>();
		String returnString = null;
		Connection conn = null;
		
		try{
			
			conn = DataBaseCon.DBConn();
			query = conn.prepareStatement("select * from test.first");
			ResultSet rs = query.executeQuery();
			
			while(rs.next()){
				myString.add(rs.getString("firstname"));	
			}
			
			query.close();
			
			returnString="<p>Database Status</p>" + "<p>Database data return: " + myString + "</p>";
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(conn!=null) conn.close();
		}
		
		return returnString;
	}
}
