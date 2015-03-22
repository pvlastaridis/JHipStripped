package com.mycompany.myapp;


import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;



@ComponentScan
@EnableAutoConfiguration
public class Application {
	
    private static final Logger log = LoggerFactory.getLogger(Application.class);

	
	@Inject
	private Environment env;

    public static void main(String[] args) throws UnknownHostException {
    	SpringApplication app = new SpringApplication(Application.class);
        app.setShowBanner(false);
        Environment env = app.run(args).getEnvironment();
        log.info("Access URLs:\n----------------------------------------------------------\n\t" +
                "Local: \t\thttp://127.0.0.1:{}\n\t" +
                "External: \thttp://{}:{}\n----------------------------------------------------------",
                env.getProperty("server.port"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"));
    }
}
