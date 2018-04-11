package gr.rege.ionion;

import gr.rege.ionion.info.DomainInfo;
import gr.rege.ionion.info.SubscriptionInfo;

public class Main {

	public static void main(String[] args) throws Exception 
	{
		String host = "alcinia.gr";
		String login = "stathis036636";
		String password = "upN7J6Pa";

		PleskApiClient client = new PleskApiClient(host);
		client.setCredentials(login, password);
		
//		DomainInfo info = new DomainInfo();
//		info.parse(client, "a-sakkali.gr");
		new SubscriptionInfo().parse(client, "a-sakkali.gr");
	}

}
