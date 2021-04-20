import java.io.Serializable;

public class UserModel  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fname;
	private String lname;
	private AddressModel address;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserModel(User user)
	{
		this.fname=user.getFname();
		this.lname=user.getLname();
		
	}
	public UserModel(String fname, String lname, AddressModel address) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.address = address;
	}
	@Override
	public String toString() {
		return "UserModel [fname=" + fname + ", lname=" + lname + ", addressModel=" + address + "]";
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public AddressModel getAddress() {
		return address;
	}
	public void setAddress(AddressModel address) {
		this.address = address;
	}

}
