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
	
	public static String AddbookpayLoad(String bookname, String isbn, String aisle) {
		String add="{\r\n" + 
				"\r\n" + 
				"\"name\":\""+bookname+"\",\r\n" + 
				"\"isbn\":\""+isbn+"\",\r\n" + 
				"\"aisle\":\""+aisle+"\",\r\n" + 
				"\"author\":\"John foe\"\r\n" + 
				"}\r\n";
		return add;
	}
	
	public static String createissuePay() {
		
		String cre="{\r\n" + 
				"    \"fields\": {\r\n" + 
				"       \"project\":\r\n" + 
				"       {\r\n" + 
				"          \"key\": \"DMS\"\r\n" + 
				"       },\r\n" + 
				"       \"summary\": \"REST ye merry gentlemen.\",\r\n" + 
				"       \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n" + 
				"       \"issuetype\": {\r\n" + 
				"          \"name\": \"Bug\"\r\n" + 
				"       }\r\n" + 
				"   }\r\n" + 
				"}";
		
		return cre;
	}

	
}
