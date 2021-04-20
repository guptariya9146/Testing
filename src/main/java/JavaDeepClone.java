import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class JavaDeepClone
  {
	
	 

	public static void main(String[] args) {
		
		 Address address = new Address("Downing St 10", "London", "England");
		 User user = new User("Prime", "Minister", address);
		 
		 UserModel userModel=(UserModel)deepClone(user);
		 System.out.println(userModel);
			/*
			 * ByteArrayOutputStream bos = new ByteArrayOutputStream(); ObjectOutputStream
			 * oos = null; UserModel userModelVo; try {
			 * 
			 * oos = new ObjectOutputStream(bos); oos.writeObject(user); byte[] byteData =
			 * bos.toByteArray(); ByteArrayInputStream bais = new
			 * ByteArrayInputStream(byteData); userModelVo = (UserModel) new
			 * ObjectInputStream(bais).readObject();
			 * 
			 * 
			 * } catch(Exception e) { e.printStackTrace(); return;
			 * 
			 * }
			 */
		 

	     
	         

		     
	}
	 public static Object deepClone(Object object) {
		    try {
		      ByteArrayOutputStream baos = new ByteArrayOutputStream();
		      ObjectOutputStream oos = new ObjectOutputStream(baos);
		      oos.writeObject(object);
		      ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		      ObjectInputStream ois = new ObjectInputStream(bais);
		      return ois.readObject();
		    }
		    catch (Exception e) {
		      e.printStackTrace();
		      return null;
		    }
}
  }



