package rpc_s;

import javax.jws.WebService;


@WebService
public interface CallWebService {
	
	public int add(int x, int y);

}
