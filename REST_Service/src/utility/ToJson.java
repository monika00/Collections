package utility;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import org.owasp.esapi.ESAPI;

import java.sql.ResultSet;

public class ToJson {

	public JSONArray toJSONArray(ResultSet rs) throws Exception{
		
		JSONArray json = new JSONArray();
		String temp = null;
		
		try{
			
			java.sql.ResultSetMetaData rsmd = rs.getMetaData();
			
			while(rs.next()){
				
				int numColumns = rsmd.getColumnCount();
				
				JSONObject obj = new JSONObject();
				
				for(int i=1;i<numColumns+1;i++){
					
					String column_name = rsmd.getColumnName(i);
					
					if(rsmd.getColumnType(i)==java.sql.Types.ARRAY){
						obj.put(column_name, rs.getArray(column_name));
						System.out.println("ToJson: ARRAY");
                    }
                    else if(rsmd.getColumnType(i)==java.sql.Types.BIGINT){
                    	obj.put(column_name, rs.getInt(column_name));
                   	 	System.out.println("ToJson: BIGINT");
                    }
                    else if(rsmd.getColumnType(i)==java.sql.Types.BOOLEAN){
                   	 	obj.put(column_name, rs.getBoolean(column_name));
                   	    System.out.println("ToJson: BOOLEAN");
                    }
                    else if(rsmd.getColumnType(i)==java.sql.Types.BLOB){
                   	 	obj.put(column_name, rs.getBlob(column_name));
                   	 	System.out.println("ToJson: BLOB");
                    }
                    else if(rsmd.getColumnType(i)==java.sql.Types.DOUBLE){
                   	 	obj.put(column_name, rs.getDouble(column_name)); 
                   	 	System.out.println("ToJson: DOUBLE");
                    }
                    else if(rsmd.getColumnType(i)==java.sql.Types.FLOAT){
                   	 	obj.put(column_name, rs.getFloat(column_name));
                   	 	System.out.println("ToJson: FLOAT");
                    }
                    else if(rsmd.getColumnType(i)==java.sql.Types.INTEGER){
                   	 	obj.put(column_name, rs.getInt(column_name));
                   	 	System.out.println("ToJson: INTEGER");
                    }
                    else if(rsmd.getColumnType(i)==java.sql.Types.NVARCHAR){
                   	 	obj.put(column_name, rs.getNString(column_name).replaceAll("\\s+",""));
                   	 	System.out.println("ToJson: NVARCHAR");
                    }
                    else if(rsmd.getColumnType(i)==java.sql.Types.VARCHAR){
                    	obj.put(column_name, rs.getString(column_name).replaceAll("\\s+",""));
                    	
                   	 	/*temp = rs.getString(column_name); //saving column data to temp variable
                   	 	temp = ESAPI.encoder().canonicalize(temp); //decoding data to base state
                   	 	temp = ESAPI.encoder().encodeForHTML(temp); //encoding to be browser safe
                   	 	obj.put(column_name, temp); //putting data into JSON object*/
                    	System.out.println("ToJson: VARCHAR");
                   	 
                    }
                    else if(rsmd.getColumnType(i)==java.sql.Types.TINYINT){
                   	 	obj.put(column_name, rs.getInt(column_name));
                   	 	System.out.println("ToJson: TINYINT");
                    }
                    else if(rsmd.getColumnType(i)==java.sql.Types.SMALLINT){
                   	 	obj.put(column_name, rs.getInt(column_name));
                   	 	System.out.println("ToJson: SMALLINT");
                    }
                    else if(rsmd.getColumnType(i)==java.sql.Types.DATE){
                   	 	obj.put(column_name, rs.getDate(column_name));
                   	 	System.out.println("ToJson: DATE");
                    }
                    else if(rsmd.getColumnType(i)==java.sql.Types.TIMESTAMP){
                   	 	obj.put(column_name, rs.getTimestamp(column_name));
                   	 	System.out.println("ToJson: TIMESTAMP");
                    }
                    else if(rsmd.getColumnType(i)==java.sql.Types.NUMERIC){
                   	 	obj.put(column_name, rs.getBigDecimal(column_name));
                   	 	System.out.println("ToJson: NUMERIC");
                     }
                    else if(rsmd.getColumnType(i)==java.sql.Types.CHAR){
                    	//obj.put(column_name, rs.getString(column_name).replaceAll("\\s+",""));
                    	//System.out.println("ToJson: CHAR");
                    	
                    	temp = rs.getString(column_name).replaceAll("\\s+",""); //saving column data to temp variable
                   	 	temp = ESAPI.encoder().canonicalize(temp); //decoding data to base state
                   	 	temp = ESAPI.encoder().encodeForHTML(temp); //encoding to be browser safe
                   	 	obj.put(column_name, temp); //putting data into JSON object
                    }
                    else {
                   	 	obj.put(column_name, rs.getObject(column_name));
                   	 	System.out.println("ToJson: Object "+column_name);
                    } 

				}//end foreach
				
				json.put(obj);
				
			}// end while
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return json;
	}
}
