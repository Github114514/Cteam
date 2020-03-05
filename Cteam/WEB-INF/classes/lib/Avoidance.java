package lib;

public class Avoidance{
	public static String TextAvoidance(String text){
		String hyperText = text.replace("&", "&amp;").replace("\"", "&quot;")
		.replace("<", "&lt;").replace(">", "&gt;").replace("'", "&#39;")
		.replace("\r\n", "<br>");

		return hyperText;
	}
}
