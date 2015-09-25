package rpc_s;

import javax.xml.ws.Endpoint;

public class Publish {
	
	public static void main(String[] args){
		Endpoint endpoint = Endpoint.publish("http://localhost:8080/cal", new CallWebServiceImpl());
		System.out.println(endpoint.isPublished());
	}

}
