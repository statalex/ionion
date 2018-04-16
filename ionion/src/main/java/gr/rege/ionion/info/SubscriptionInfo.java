package gr.rege.ionion.info;

import java.io.StringReader;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.velocity.VelocityContext;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import gr.rege.ionion.PleskApiClient;
import gr.rege.ionion.helper.PleskUtil;
import gr.rege.ionion.helper.XmlMap;

public class SubscriptionInfo 
{
	static Logger log = LogManager.getLogger( SubscriptionInfo.class);
	
	public static int d;
	public long diskSpace;
	public long mailboxQuota;
	
	public SubscriptionInfo parse( PleskApiClient client, String name) throws Exception
	{
		PleskUtil util = new PleskUtil();
		VelocityContext ctx = new VelocityContext();
		ctx.put("name", name);
		String response = client.request( util.getRequest("subscription_info_req", ctx));
		log.debug(response);
		StringReader strReader = new StringReader( response);
		SAXReader reader = new SAXReader();
		Document document = reader.read( strReader );
		util.setCurNode( document.selectSingleNode("/packet/webspace/get/result/data/limits" ));
		List<Node> nodeList = util.getNodeList("limit");
		XmlMap map = new XmlMap();
		for( Node node: nodeList)
		{
			if( node.getNodeType() == Node.ELEMENT_NODE)
				map.putNamedValue( (Element)node);
		}
		diskSpace = map.getLong("disk_space");
		mailboxQuota = map.getLong("mbox_quota");
		return this;
	}

}

