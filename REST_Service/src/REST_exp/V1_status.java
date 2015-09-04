package REST_exp;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/V1/status")
public class V1_status {

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnTitle(){
		return "<p>Java Web Service</p>";
	}
	
}
