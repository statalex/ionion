package gr.rege.ionion.helper;

import java.io.StringWriter;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.dom4j.Node;

public class PleskUtil 
{
	static Logger log = LogManager.getLogger( PleskUtil.class);

	private Node curNode;
	private static String tmplPath="gr/rege/ionion/templates/";

	
	public String getRequest( String tmplName, VelocityContext ctx) 
	{
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();
        Template t = ve.getTemplate( tmplPath+tmplName+".vm" );
        StringWriter writer = new StringWriter();
        t.merge( ctx, writer );
        log.debug( writer.toString());
        return writer.toString();
	}
	
	
	public Node getCurNode() {	return curNode;	}
	public void setCurNode(Node curNode) {	this.curNode = curNode;	}

	
	
	public void setCurNode( String path) 
	{	
		this.curNode = getNode(path);	
	}
	
	
	public Node getNode(String path) 
	{	
		return curNode.selectSingleNode( path );
	}

	@SuppressWarnings("unchecked")
	public List<Node> getNodeList(String path) 
	{	
		return curNode.selectNodes( path );
	}
	

	private String getText( String path)
	{
		Node node= curNode.selectSingleNode( path );
		return node.getText();
//		List<Node> nodeList = curNode.selectNodes( path );
//		return nodeList.get(0).getText();
	}

	public int asInt( String path)
	{
		return new Integer( getText(path));
	}

	public long asLong( String path)
	{
		return new Long( getText(path));
	}

	public String asString( String path)
	{
		return getText(path);
	}

	public static int getInt( Node node)
	{
		return new Integer( node.getText());
	}

	public static long getLong( Node node)
	{
		return new Long( node.getText());
	}

	public static String getString( Node node)
	{
		return node.getText();
	}

}
