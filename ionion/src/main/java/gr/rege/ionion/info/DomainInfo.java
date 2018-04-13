package gr.rege.ionion.info;

import java.io.StringReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.velocity.VelocityContext;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;

import gr.rege.ionion.PleskApiClient;
import gr.rege.ionion.helper.PleskUtil;


public class DomainInfo 
{
	static Logger log = LogManager.getLogger( DomainInfo.class);
	
	public int id;
	public String name;
	public String ipAddress;
	public String status;
	public int realSize;

	public DiskUsageInfo usage;

	public DomainInfo parse( PleskApiClient client, String name) throws Exception
	{
		PleskUtil util = new PleskUtil();
		VelocityContext ctx = new VelocityContext();
		ctx.put("name", name);
		String response = client.request( util.getRequest("domain_info_req", ctx));
		log.debug( response);
		StringReader strReader = new StringReader( response);
		SAXReader reader = new SAXReader();
		Document document = reader.read( strReader );
		util.setCurNode( document.selectSingleNode("/packet/webspace/get/result" ));
		status=util.asString( "status");
		id=util.asInt( "id");
		util.setCurNode("data/gen_info");
		name=util.asString("name");
		ipAddress=util.asString("dns_ip_address");
		realSize=util.asInt("real_size");
		util.setCurNode( document.selectSingleNode("/packet/webspace/get/result/data/disk_usage" ));
		DiskUsageInfo di = new DiskUsageInfo();
		di.http_docs = util.asInt("httpdocs");
		di.http_docs = util.asInt("httpsdocs");
		di.subdomains = util.asInt("subdomains");
		di.web_users = util.asInt("web_users");
		di.anonftp = util.asInt("anonftp");
		di.logs = util.asInt("logs");
		di.dbases = util.asInt("dbases");
		di.mailboxes = util.asInt("mailboxes");
		di.domaindumps = util.asInt("domaindumps");
		di.webapps = util.asInt("webapps");
		di.maillists = util.asInt("maillists");
		di.configs = util.asInt("configs");
		return this;
	}

}
