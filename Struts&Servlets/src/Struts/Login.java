package Struts;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class Login implements SessionAware {

	private String name, password;
	private SessionMap<String, Object> sessionMap;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setSession(Map<String, Object> map) {
		sessionMap = (SessionMap) map;
	}

	public String execute() {
		if (password.equals("admin")) {
			sessionMap.put("login", "true");
			sessionMap.put("name", name);

			return "success";
		} else {
			return "login";
		}
	}

	public String logout() {
		if (sessionMap != null) {
			sessionMap.invalidate();
		}

		return "success";
	}

}
