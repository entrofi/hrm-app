/*
 * Copyright 2003-2016 Monitise Group Limited. All Rights Reserved.
 *
 * Save to the extent permitted by law, you may not use, copy, modify,
 * distribute or create derivative works of this material or any part
 * of it without the prior written consent of Monitise Group Limited.
 * Any reproduction of this material must contain this notice.
 */
package net.entrofi.hrm.rest.resources;

import net.entrofi.hrm.rest.webapp.HRMApplication;
import net.entrofi.hrm.rest.webapp.ProfileNames;
import org.glassfish.jersey.CommonProperties;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.test.DeploymentContext;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.ServletDeploymentContext;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.ContextLoaderListener;

import javax.ws.rs.core.Application;
import java.util.Set;

/**
 * TODO add javadoc
 * Created on 15/12/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {ResourceTestConfigurer.class})
@ActiveProfiles(ProfileNames.UNIT_TEST)
public abstract class AbstractResourceTest extends JerseyTest{

    protected Application configure() {
        ResourceConfig resourceConfig = new HRMApplication();
        resourceConfig.property(CommonProperties.MOXY_JSON_FEATURE_DISABLE, true);
        resourceConfig.property(CommonProperties.MOXY_JSON_FEATURE_DISABLE_CLIENT, true);
        resourceConfig.property("contextConfigLocation", "classpath:spring/test-hrm-mongodb-applicationContext.xml");
        return resourceConfig;
    }

//    @Override
//    protected TestContainerFactory getTestContainerFactory() {
//        return new JettyTestContainerFactory();
//    }

    protected DeploymentContext configureDeployment() {
        Application app = configure();
        return ServletDeploymentContext.builder(app)
                .servlet(new ServletContainer((ResourceConfig)app))
                .addListener(ContextLoaderListener.class)
                .contextParam("contextConfigLocation", "classpath:spring/test-hrm-mongodb-applicationContext.xml")
                .build();
    }

}
