package files;

public class Resources {

	
	public static String post() {
		String postreq= "/maps/api/place/add/json";
		return postreq;
	} 
	
	public static String delete() {
		String deletereq="/maps/api/place/delete/json";
		return deletereq;
	}
	
	public static String Addbook() {
		String add="/Library/Addbook.php";
		return add;
	}
}
