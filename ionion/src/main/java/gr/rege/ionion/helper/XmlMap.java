package gr.rege.ionion.helper;

import java.util.HashMap;

import org.dom4j.Element;
import org.dom4j.Node;

public class XmlMap extends HashMap<String, String> 
{
	private static final long serialVersionUID = -6028558500886160789L;

	private Node node;

	public XmlMap() 
	{
	}
	
	public XmlMap( Node theNode) 
	{
		this.node = theNode;
	}
	
	public void put( String path)
	{
		super.put( path, node.selectSingleNode( path ).getText());
	}

	
	public void putNamedValue( Element elm)
	{
		
		String name=elm.node(1).getText();
		String value=elm.node(3).getText();
		super.put( name, value);
	}
	
	public String getString(String key)
	{
		return super.get( key);
	}

	public Integer getInt(String key)
	{
		return new Integer( super.get(key));
	}

}
