import java.io.StringReader;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class Dom4jTest {

	static String str1=
"<?xml version = \"1.0\"?>\n" + 
"<class>\n" + 
"   <student rollno = \"393\">\n" + 
"      <firstname>dinkar</firstname>\n" + 
"      <lastname>kad</lastname>\n" + 
"      <nickname>dinkar</nickname>\n" + 
"      <marks>85</marks>\n" + 
"   </student>\n" + 
"   \n" + 
"   <student rollno = \"493\">\n" + 
"      <firstname>Vaneet</firstname>\n" + 
"      <lastname>Gupta</lastname>\n" + 
"      <nickname>vinni</nickname>\n" + 
"      <marks>95</marks>\n" + 
"   </student>\n" + 
"   \n" + 
"   <student rollno = \"593\">\n" + 
"      <firstname>jasvir</firstname>\n" + 
"      <lastname>singn</lastname>\n" + 
"      <nickname>jazz</nickname>\n" + 
"      <marks>90</marks>\n" + 
"   </student>\n" + 
"</class>";

	
	static String str2="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + 
			"	<packet version=\"1.6.9.0\">\n" + 
			"	  <webspace>\n" + 
			"	    <get>\n" + 
			"	      <result>\n" + 
			"	        <status>ok</status>\n" + 
			"	        <filter-id>a-sakkali.gr</filter-id>\n" + 
			"	        <id>1072</id>\n" + 
			"	        <data>\n" + 
			"	          <gen_info>\n" + 
			"	            <cr_date>2014-04-08</cr_date>\n" + 
			"	            <name>a-sakkali.gr</name>\n" + 
			"	            <ascii-name>a-sakkali.gr</ascii-name>\n" + 
			"	            <status>0</status>\n" + 
			"	            <real_size>485439651</real_size>\n" + 
			"	            <owner-id>281</owner-id>\n" + 
			"	            <dns_ip_address>185.4.133.224</dns_ip_address>\n" + 
			"	            <htype>vrt_hst</htype>\n" + 
			"	            <guid>64caa700-1a26-4947-a49f-fe77139282e5</guid>\n" + 
			"	            <vendor-guid>1ba4d0b4-70ec-4181-bd6d-b900ce1ac1d8</vendor-guid>\n" + 
			"	            <external-id/>\n" + 
			"	            <sb-site-uuid/>\n" + 
			"	            <description/>\n" + 
			"	          </gen_info>\n" + 
			"	          <disk_usage>\n" + 
			"	            <httpdocs>379359232</httpdocs>\n" + 
			"	            <httpsdocs>0</httpsdocs>\n" + 
			"	            <subdomains>0</subdomains>\n" + 
			"	            <web_users>0</web_users>\n" + 
			"	            <anonftp>0</anonftp>\n" + 
			"	            <logs>15912960</logs>\n" + 
			"	            <dbases>4098211</dbases>\n" + 
			"	            <mailboxes>86056960</mailboxes>\n" + 
			"	            <webapps>0</webapps>\n" + 
			"	            <maillists>0</maillists>\n" + 
			"	            <domaindumps>0</domaindumps>\n" + 
			"	            <configs>8192</configs>\n" + 
			"	            <chroot>4096</chroot>\n" + 
			"	          </disk_usage>\n" + 
			"	        </data>\n" + 
			"	      </result>\n" + 
			"	    </get>\n" + 
			"	  </webspace>\n" + 
			"	</packet>\n" + 
			"";
	
	
	
	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) 
	{
		StringReader strReader = new StringReader(str2);
		try 
		{
			SAXReader reader = new SAXReader();
			Document document = reader.read( strReader/*inputFile*/ );

			System.out.println("Root element :" + document.getRootElement().getName());
			List<Node> nodeList = document.selectNodes("/packet/webspace/get/result" );
			Node resultNode = nodeList.get(0);
			nodeList = resultNode.selectNodes("status" );
			System.out.println( "Status = "+getValue( resultNode, "status"));
			System.out.println( "ID = "+getValue( resultNode, "id"));
		} catch (DocumentException e) 
		{
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	static String getValue( Node node, String path)
	{
		List<Node> nodeList = node.selectNodes( path );
		return nodeList.get(0).getText();
		
	}

}
