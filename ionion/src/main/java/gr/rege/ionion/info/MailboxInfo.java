package gr.rege.ionion.info;

import java.io.StringReader;

import org.apache.velocity.VelocityContext;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;

import gr.rege.ionion.PleskApiClient;
import gr.rege.ionion.helper.PleskUtil;

public class MailboxInfo 
{
	public void parse( PleskApiClient client, String name) throws Exception
	{
		PleskUtil util = new PleskUtil();
		VelocityContext ctx = new VelocityContext();
		ctx.put("name", name);
		String response = client.request( util.getRequest("domain_info_req", ctx));
		StringReader strReader = new StringReader( response);
		SAXReader reader = new SAXReader();
		Document document = reader.read( strReader );
		util.setCurNode( document.selectSingleNode("/packet/webspace/get/result" ));
//		status=util.asString( "status");
//		id=util.asInt( "id");
		util.setCurNode("data/gen_info");
		name=util.asString("name");
//		ipAddress=util.asString("dns_ip_address");
//		realSize=util.asInt("real_size");
		util.setCurNode( document.selectSingleNode("/packet/webspace/get/result/data/disk_usage" ));
	}

}
