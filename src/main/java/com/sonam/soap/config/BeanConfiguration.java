package com.sonam.soap.config;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
//import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sonam.soap.Greeter;
import com.sonam.soap.TibetanGreeter;

@Configuration
public class BeanConfiguration {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Bean(name = Bus.DEFAULT_BUS_ID, destroyMethod = "shutdown")
    public SpringBus springBus() {
	logger.info("springBus setup");
	return new SpringBus();
    }

    @Bean
    public Server greeterEndpoint(ApplicationContext appContext) {
	logger.debug("creating jaxws endpoint greeter");

	JaxWsServerFactoryBean svrFactory = new JaxWsServerFactoryBean();
	svrFactory.setServiceClass(Greeter.class);
	// This is the service contract
	svrFactory.setServiceBean(greeter());
	svrFactory.setAddress("/greeterService");
	return svrFactory.create();
    }

    /*
     * @Bean public ServletRegistrationBean cxfServlet( ) {
     * ServletRegistrationBean servlet = new ServletRegistrationBean( new
     * CXFServlet( ), "/services/*" ); servlet.setLoadOnStartup( 1 ); return
     * servlet; }
     */

    @Bean
    public Greeter greeter() {
	return new TibetanGreeter();
    }
}
