package DAO;

import java.sql.*;

import org.codehaus.jettison.json.JSONArray;

import utility.ToJson;

public class DB_Schema {
	
	public int deleteData(String firstname, String lastname) throws Exception{
		
		System.out.println("dbSchema: " +firstname+lastname);
		
		PreparedStatement query = null;
		Connection conn = null;
	
		try{
			conn =  DataBaseCon.DBConn();
			query = conn.prepareStatement("DELETE FROM test.first WHERE firstname = ? and lastname = ?");
		
			query.setString(1, firstname.replaceAll("\\s+",""));
			query.setString(2, lastname.replaceAll("\\s+",""));
			
			query.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
			return 500;
		}
		catch(Exception e){
			e.printStackTrace();
			return 500;
		}
		finally{
			if(conn!=null) conn.close();
		}
		
		return 200;
	}
	
	public int updateData(String f_name, String l_name) throws Exception{
		System.out.println(l_name);
		System.out.println(f_name);
	
		PreparedStatement query = null;
		Connection conn = null;
	
		try{
			conn =  DataBaseCon.DBConn();
			query = conn.prepareStatement("UPDATE test.first SET firstname = ? WHERE lastname = ?");
		
			query.setString(1, f_name);
			query.setString(2, l_name);
			
			query.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
			return 500;
		}
		catch(Exception e){
			e.printStackTrace();
			return 500;
		}
		finally{
			if(conn!=null) conn.close();
		}
		
		return 200;
	}
	
	public int queryInsertData(String firstname, String lastname) throws Exception{
		
		PreparedStatement query = null;
		Connection conn = null;
	
		try{
			conn =  DataBaseCon.DBConn();
			query = conn.prepareStatement("INSERT INTO test.first (firstname,lastname) VALUES (?,?) ");
		
			query.setString(1, firstname);
			query.setString(2, lastname);
			
			query.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
			return 500;
		}
		catch(Exception e){
			e.printStackTrace();
			return 500;
		}
		finally{
			if(conn!=null) conn.close();
		}
		
		return 200;
	}
	
	
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
	
	public JSONArray queryReturnDataSpecific(String data, String data_2) throws Exception{
		
		PreparedStatement query = null;
		Connection conn = null;
	
		ToJson converter = new ToJson();
		JSONArray json = new JSONArray();
	
		try{
			conn =  DataBaseCon.DBConn();
			query = conn.prepareStatement("select test.first.firstname,test.first.lastname from test.first where "
					+"UPPER(test.first.firstname) = ? and UPPER(test.first.lastname) = ?");
		
			query.setString(1, data.toUpperCase());
			query.setString(2, data_2.toUpperCase());
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
