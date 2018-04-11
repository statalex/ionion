package gr.rege.ionion.info;

import java.io.StringReader;
import java.util.Iterator;
import java.util.List;

import org.apache.velocity.VelocityContext;
import org.dom4j.Branch;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import gr.rege.ionion.PleskApiClient;
import gr.rege.ionion.helper.ParseUtil;

public class SubscriptionInfo 
{
	public void parse( PleskApiClient client, String name) throws Exception
	{
		ParseUtil util = new ParseUtil();
		VelocityContext ctx = new VelocityContext();
		ctx.put("name", name);
		String response = client.request( util.getRequest("subscription_info_req", ctx));
//		System.out.println( response);
		
		StringReader strReader = new StringReader( response);
		SAXReader reader = new SAXReader();
		Document document = reader.read( strReader );
		util.setCurNode( document.selectSingleNode("/packet/webspace/get/result/data/limits" ));
//		Node node = document.selectSingleNode("/packet/webspace/get/result/data/limits" );
		List<Node> nodeList = util.getNodeList("limit");
//		System.out.println( nodeList.size());
		for( Node node: nodeList)
		{
//			System.out.println("============================");
			switch( node.getNodeType())
			{
				case Node.ELEMENT_NODE :
					Element elm = (Element)node;
//					System.out.println( "** "+elm.nodeCount());
					String subName="";
					String subValue="";
					for (Iterator iterator = elm.nodeIterator(); iterator.hasNext();) 
					{
						Node sub = (Node) iterator.next();
//						System.out.println("["+sub.getName()+"="+sub.getText()+"]");
//						System.out.println("{"+sub.asXML()+"}");
						if( sub.getName() != null)
						{
//							System.out.println("<"+sub.getName()+"="+sub.getText()+">");
							if( sub.getName().compareTo("name")==0)
								subName=sub.getText();
							if( sub.getName().compareTo("value")==0)
								subValue=sub.getText();
						}
					}
					System.out.println("("+subName+"="+subValue+")");
//					System.out.println( elm.asXML());
					break;
				case Node.ATTRIBUTE_NODE :
					break;
			}
//			System.out.println(node.getName()+"="+node.getStringValue());
		}
		System.out.println( util.getCurNode());
//		System.out.println( util.asString("disk_space"));
//		status=util.asString( "status");
//		id=util.asInt( "id");
//		util.setCurNode("data/gen_info");
//		name=util.asString("name");
//		ipAddress=util.asString("dns_ip_address");
//		realSize=util.asInt("real_size");
//		util.setCurNode( document.selectSingleNode("/packet/webspace/get/result/data/disk_usage" ));
		
	}

}

