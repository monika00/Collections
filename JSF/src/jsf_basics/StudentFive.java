package jsf_basics;

import javax.faces.bean.ManagedBean;


@ManagedBean
public class StudentFive {
	
	private String firstName;
	private String lastName;
	
	private String favoriteLanguages;
	
	public StudentFive(){
		
		firstName = "Mary";
		lastName = "Stevenson";
		favoriteLanguages = "Java";
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastnmae) {
		this.lastName = lastnmae;
	}

	public String getFavoriteLanguages() {
		return favoriteLanguages;
	}

	public void setFavoriteLanguages(String favoritelanguages) {
		this.favoriteLanguages = favoritelanguages;
	}
	
	
}
