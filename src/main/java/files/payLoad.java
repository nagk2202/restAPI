package files;


public class payLoad {


	public static String Postbody() {
		String b="{" + 
				"\"location\":{" + 
				"\"lat\" : -38.383494," + 
				"\"lng\" : 33.427362" + 
				"}," + 
				"\"accuracy\":50," + 
				"    \"name\":\"Frontline house\"," + 
				"    \"phone_number\":\"(+91) 983 893 3937\"," + 
				"    \"address\" : \"29, side layout, cohen 09\"," + 
				"    \"types\": [\"shoe park\",\"shop\"]," + 
				"    \"website\" : \"http://google.com\"," + 
				"    \"language\" : \"French-IN\""  	 	+ 
				"}";
		
		return b;
	}
	
	public static String deletebody(String place) {
		String s="{"+
			    "\"place_id\": \"" + place + "\"" +
		"}";

		return s;
	}
	
	public static String AddbookpayLoad() {
		String add="{\r\n" + 
				"\r\n" + 
				"\"name\":\"mahesh\",\r\n" + 
				"\"isbn\":\"nag\",\r\n" + 
				"\"aisle\":\"227\",\r\n" + 
				"\"author\":\"John foe\"\r\n" + 
				"}\r\n";
		return add;
	}
}
