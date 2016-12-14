package net.entrofi.hrm.rest.webapp;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by hasan on 12/17/2016.
 */
@Configuration
@EnableMongoRepositories("net.entrofi.hrm.domain.repository")
@ComponentScan({"net.entrofi.hrm"})
public class HRMRestSpringConfigurer {


    @Bean(name = "mongoClient")
    public MongoClient mongoClient() throws Exception {
        return new MongoClient();
    }

    @Bean(name = "mongoTemplate")
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(new SimpleMongoDbFactory(mongoClient(), getDatabaseName()));
    }

    /**
     * TODO remove
     * @return
     */
    @Deprecated
    protected String getDatabaseName() {
        return "hrm_mongo_test";
    }
}
