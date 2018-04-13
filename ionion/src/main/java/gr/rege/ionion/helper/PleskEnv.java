package gr.rege.ionion.helper;

import java.io.File;

import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.configuration2.CompositeConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import gr.rege.ionion.PleskApiClient;
import gr.rege.ionion.RunMode;
import gr.rege.ionion.unit.ByteUsage;

public class PleskEnv 
{
	static Logger log = LogManager.getLogger( PleskEnv.class);
	
	public String address = null;
	public String login = null;
	public String password = null;
	public String domain = null;
	public RunMode mode = null;
	public ByteUsage warning = new ByteUsage("75%");
	public ByteUsage error = new ByteUsage("90%");

	public PleskApiClient client;
	
	private String[] args;
	private Option helpOption		= new Option( "h", "help", false, "print this message" );
	private Option addressOption	= new Option( "a", "address", true, "address of Plesk" );
	private Option userOption		= new Option( "u", "user", true, "Login user" );
	private Option passwordOption	= new Option( "p", "password", true, "Login password" );
	private Option domainOption		= new Option( "d", "domain", true, "domain to be examined" );
	private Option modeOption		= new Option( "m", "mode", true, "Can be one of (domain, mbox)" );
	private Option warningOption	= new Option( "w", "warning", true, "Warning level. default 75%" );
	private Option errorOption		= new Option( "e", "error", true, "Error level. default 90%" );

	private Options options = new Options();
	
	private static PleskEnv self = null;
	
	public PleskEnv(String[] theArgs) 
	{
		this.args = theArgs;
		try 
		{
			readCommandLine();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		client = new PleskApiClient( address);
		client.setCredentials(login, password);
	}
	
	public static PleskEnv get(String[] args)
	{
		if( self == null)
			self = new PleskEnv( args);
		return self;
	}

	private void readCommandLine() throws Exception
	{
		log.trace("Got it");
		readConfig();
		options.addOption( helpOption);
		options.addOption( addressOption);
		options.addOption( userOption);
		options.addOption( passwordOption);
		options.addOption( domainOption);
		options.addOption( warningOption);
		options.addOption( errorOption);
		options.addOption( modeOption);

		CommandLineParser parser = new DefaultParser();
		ExtCommandLine cli = new ExtCommandLine( parser.parse( options, args ));
		if( cli.hasOption( helpOption ) ) 
			usage(options, "");
		if( cli.hasOption(addressOption))
			address = cli.getOptionValue( addressOption);
		if( cli.hasOption(userOption))
			login = cli.getOptionValue( userOption);
		if( cli.hasOption(passwordOption))
			password = cli.getOptionValue( passwordOption);
		if( cli.hasOption(domainOption))
			domain = cli.getOptionValue( domainOption);
		if( cli.hasOption( warningOption))
			warning = new ByteUsage( cli.getOptionValue( warningOption));
		if( cli.hasOption( errorOption))
			error = new ByteUsage( cli.getOptionValue( errorOption));
		if( cli.hasOption(modeOption))
		{
			try 
			{
				mode = RunMode.value( cli.getOptionValue( modeOption));
			} catch (Exception e) {	mode=null;}
		}

		if( address==null)	usage(options, "");
		if( login==null)	usage(options, "");
		if( password==null)	usage(options, "");
		if( domain==null)	usage(options, "");
		if( mode==null)		usage(options, "");
	}

	private void usage( Options options, String msg)
	{
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp( "ionion", options );
		System.exit(3);
	}
	
	private void readConfig() throws ConfigurationException
	{
		CompositeConfiguration cfg = new CompositeConfiguration();
		Configurations configs = new Configurations();
	    cfg.addConfiguration( configs.properties(new File("META-INF/credential.properties")) );
	    cfg.addConfiguration( configs.properties(new File("META-INF/config.properties")) );

	    address = cfg.getString("plesk.host");
	    login = cfg.getString("plesk.login");
	    password = cfg.getString("plesk.password");
	    domain = cfg.getString("plesk.domain");
	}


}
