package my.experiments.services;

import javax.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration; 
 
@Configuration
public class WebServiceConfig {
    @Autowired
    private Bus bus;
    
    @Autowired
    private petLife life;
    
    @Bean
    public ServletRegistrationBean<CXFServlet> wsDispatcherServlet() {
        CXFServlet cxfServlet = new CXFServlet();
        return new ServletRegistrationBean<CXFServlet>(cxfServlet, "/ws/*");
    }
 
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new myPetSOAPService(life));
        endpoint.publish("/MyKitty");
        return endpoint;
    }
}