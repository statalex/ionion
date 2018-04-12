package gr.rege.ionion;

import java.io.File;

import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.configuration2.CompositeConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gr.rege.ionion.helper.ExtCommandLine;
import gr.rege.ionion.helper.PleskEnv;
import gr.rege.ionion.info.SubscriptionInfo;

public class Main 
{
	static Logger logger = LoggerFactory.getLogger( Main.class);
	

	public static void main(String[] args) throws Exception 
	{
		PleskEnv env = PleskEnv.get(args);
		
		
		switch( env.mode)
		{
			case DOMAIN :
				new DomainChecker(env).check();
				break;
			case MBOX :
				break;
		}
	}


	
}
