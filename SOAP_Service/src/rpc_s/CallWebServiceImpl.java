package rpc_s;

import javax.jws.WebService;

@WebService(endpointInterface="rpc_s.CallWebService",
portName="callWebServicePort",
serviceName="callWebService")
public class CallWebServiceImpl implements CallWebService{
	
	public int add(int x, int y){
		
		return x+y;
	}	

}
