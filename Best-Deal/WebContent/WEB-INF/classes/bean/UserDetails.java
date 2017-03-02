package bean;

public class UserDetails {
	String password;
	String address;
	String occupation;
	String name;
	String gender;
	String age;
	String salesmanId;
	String username;

	public UserDetails(String username, String password, String name, String address, String occupation, String gender,
			String age, String salesmanId) {
		this.password = password;
		this.address = address;
		this.occupation = occupation;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.salesmanId = salesmanId;
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOccupation() {
		return occupation;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setOccupation(String phone) {
		this.occupation = occupation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSalesmanId() {
		return salesmanId;
	}

	public void setSalesmanId(String salesmanId) {
		this.salesmanId = salesmanId;
	}

}
