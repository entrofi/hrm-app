package net.entrofi.hrm.rest.webapp;


import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import javax.ws.rs.ApplicationPath;

/*******************************************************************************
 *
 *
 * DOC documentation:type_definition Please provide <b><u>detailed</u></b> class definition.
 * Sample Start: This class is a part of HRM application
 * and is responsible of accessing remote machines with the use of different 
 * protocols.
 *
 *
 * @author Hasan COMAK
 * @created Dec 14, 2014
 * @version Dec 14, 2014
 * @since TODO insert the product line
 * @see <Add inherited classes>
 ******************************************************************************/
@ApplicationPath("/")
public class HRMApplication extends ResourceConfig {

    private final static java.util.logging.Logger LOG = java.util.logging.Logger.getGlobal();

    public HRMApplication(){
        register(JacksonFeature.class);
        register(MultiPartFeature.class);

        // Register an instance of LoggingFilter.
        register(new LoggingFilter(LOG, true));

        // Validation.
        //register(ValidationConfigurationContextResolver.class);

        //Register app specifics
//        register(new SortBinder());

        // Enable Tracing support.
        property(ServerProperties.TRACING, "ALL");

        //Enable sending error in responses
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);

        String[] packages = {"net.entrofi.hrm.rest.resources", "net.entrofi.hrm.rest.webapp"};
        property(ServerProperties.PROVIDER_PACKAGES, packages);
        packages(true,packages);

    }
}