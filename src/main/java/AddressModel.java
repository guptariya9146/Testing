

public class AddressModel  {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String city;
	private String postalCode;
	private String state;
	public AddressModel(String city, String postalCode, String state) {
		super();
		this.city = city;
		this.postalCode = postalCode;
		this.state = state;
	}
	public AddressModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}


	
	

}
