package gr.rege.ionion.helper;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.ParseException;

public class ExtCommandLine extends CommandLine
{
	private static final long serialVersionUID = 6043507413104741463L;
	private CommandLine cli;
	
	public ExtCommandLine( CommandLine theCli) 
	{
		this.cli = theCli;
	}
	
	public boolean hasOption( Option opt)
	{
		return cli.hasOption(opt.getOpt()) || cli.hasOption(opt.getLongOpt());
	}

	public String getOptionValue( Option opt)
	{
		if( cli.hasOption(opt.getOpt()))
			return cli.getOptionValue(opt.getOpt());
		return cli.getOptionValue(opt.getLongOpt());
	}

	
	public int hashCode() 												{	return cli.hashCode(); }
	public boolean hasOption(String opt) 								{ return cli.hasOption(opt); }
	public boolean hasOption(char opt) 									{ return cli.hasOption(opt);	}
//	public Object getOptionObject(String opt) { return cli.getOptionObject(opt); }
	public Object getParsedOptionValue(String opt) throws ParseException { return cli.getParsedOptionValue(opt); }
	public boolean equals(Object obj) 									{ return cli.equals(obj); }
	public Object getOptionObject(char opt) 							{ return cli.getOptionObject(opt); }
	public String getOptionValue(String opt) 							{ return cli.getOptionValue(opt); }
	public String getOptionValue(char opt) 								{ return cli.getOptionValue(opt); }
	public String[] getOptionValues(String opt) 						{ return cli.getOptionValues(opt); }
	public String[] getOptionValues(char opt) 							{ return cli.getOptionValues(opt); }
	public String getOptionValue(String opt, String defaultValue) 		{ return cli.getOptionValue(opt, defaultValue); }
	public String getOptionValue(char opt, String defaultValue) 		{ return cli.getOptionValue(opt, defaultValue); }
	public Properties getOptionProperties(String opt) 					{ return cli.getOptionProperties(opt); }
	public String[] getArgs() 											{ return cli.getArgs(); }
	public List<String> getArgList() 									{ return cli.getArgList(); }
	public String toString() 											{ return cli.toString(); }
	public Iterator<Option> iterator() 									{ return cli.iterator(); }
	public Option[] getOptions() 										{ return cli.getOptions(); }
	
	
}
