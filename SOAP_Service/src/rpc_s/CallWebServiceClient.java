package rpc_s;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import rpc_s.CallWebService;;
 

public class CallWebServiceClient {
	
	public static void main(String[] args) throws MalformedURLException{
		
		URL url = new URL("http://localhost:8080/SOAP_Service/CallWebService?wsdl");
		QName qname = new QName("http://Soap_service/", "CallWebServiceImpl");
		
		Service service = Service.create(url, qname);
		
		CallWebService webService = service.getPort(CallWebService.class);
		
		System.out.println(webService.add(10, 7));
		
	}

}
