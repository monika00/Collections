package REST_exp;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


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
	
}
