package gr.rege.ionion;


// Copyright 1999-2016. Parallels IP Holdings GmbH. All Rights Reserved.

class Example 
{

	public static void main(String[] args) throws Exception 
	{
/*    	
    	$host="alcinia.gr";
    	$login="stathis036636";
    	$password="upN7J6Pa";
*/
		String host = "alcinia.gr";
		String login = "stathis036636";
		String password = "upN7J6Pa";

		PleskApiClient client = new PleskApiClient(host);
		client.setCredentials(login, password);

		String request =
				"<packet>" +
				"<server>" +
				"<get_protos/>" +
				"</server>" +
				"</packet>";

		String response = client.request(request);
		System.out.println(response);
	}

}
