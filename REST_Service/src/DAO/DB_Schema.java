package DAO;

import java.sql.*;

import org.codehaus.jettison.json.JSONArray;

import utility.ToJson;

public class DB_Schema {
	
	public JSONArray queryReturnData(String data) throws Exception{
	
		PreparedStatement query = null;
		Connection conn = null;
	
		ToJson converter = new ToJson();
		JSONArray json = new JSONArray();
	
		try{
			conn =  DataBaseCon.DBConn();
			query = conn.prepareStatement("select test.first.firstname,test.first.lastname from test.first where UPPER(test.first.firstname) = ?");
		
			query.setString(1, data.toUpperCase());
			ResultSet rs = query.executeQuery();
		
			json = converter.toJSONArray(rs);
			query.close();
		}
		catch(SQLException e){
			e.printStackTrace();
			return json;
		}
		catch(Exception e){
			e.printStackTrace();
			return json;
		}
		finally{
			if(conn!=null) conn.close();
		}
		
		return json;
	}
	
}
