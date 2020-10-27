package my.experiments.services;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class RunApp {

    public static void main(String[] args) {
    	//Если без src\main\resources\application.properties
    	//SpringApplication springApp = new SpringApplication(RunApp.class);
    	//springApp.setDefaultProperties(Collections.singletonMap("server.port", (Object)"8888"));
    	//springApp.run(args);
    	//exitApplication(SpringApplication.run(RunApp.class, args));
    	SpringApplication.run(RunApp.class, args);
    }
    
    /*public static void exitApplication(ConfigurableApplicationContext ctx) {
    	int exitCode = SpringApplication.exit(ctx, new ExitCodeGenerator() {
	    		public int getExitCode() {
	    			return 0;
	    		}
    		});
    	System.exit(exitCode);
    }*/
}