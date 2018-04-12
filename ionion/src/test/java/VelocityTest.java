import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

public class VelocityTest 
{
	
	public static void main(String[] args) {
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();
/*        
        Properties props = new Properties();
        props.put(RuntimeConstants.RESOURCE_LOADER, "classpath");
//        props.put("file.resource.loader.path", "templates");
        props.setProperty("runtime.log.logsystem.class", "org.apache.velocity.runtime.log.NullLogSystem");
        ve.init( props);
*/        
        /*  next, get the Template  */
        Template t = ve.getTemplate( "gr/rege/ionion/templates/test2.vm" );
        /*  create a context and add data */
        VelocityContext ctx = new VelocityContext();
        ctx.put("name", "1733");
        /* now render the template into a StringWriter */
        StringWriter writer = new StringWriter();
        t.merge( ctx, writer );
        /* show the World */
//        System.out.println( writer.toString() ); 
        System.out.println( ctx.get("domain_info_req"));
	}
}
