import java.io.Serializable;

public class User  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fname;
	private String lname;
	private Address address;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String fname, String lname, Address address) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.address = address;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

}
