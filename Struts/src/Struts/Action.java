package Struts;

import com.opensymphony.xwork2.ActionSupport;

public class Action extends ActionSupport {


	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private float price;

	public void validate() {
		if(name.length()<1)
			addFieldError("name","Name can't be blank");
		if(price<5)
			addFieldError("password","Password must be greater than 5");
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String execute() {
		return "success";
	}

}
