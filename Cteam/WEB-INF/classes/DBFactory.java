import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class DBFactory{

	public static Object getInstance(String key) {
		ResourceBundle bundle = null;
		Object obj = null;

		try {
			bundle = ResourceBundle.getBundle("servlet");
			String name = bundle.getString(key);
			Class c = Class.forName(name);
			obj = c.newInstance();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(MissingResourceException e){
			e.printStackTrace();
		}catch(IllegalAccessException e){
			e.printStackTrace();
		}catch(InstantiationException e){
			e.printStackTrace();
		}

		return obj;
	}
}