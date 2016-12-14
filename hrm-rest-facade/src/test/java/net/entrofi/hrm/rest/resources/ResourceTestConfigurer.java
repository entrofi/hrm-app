/*
 * Copyright 2003-2016 Monitise Group Limited. All Rights Reserved.
 *
 * Save to the extent permitted by law, you may not use, copy, modify,
 * distribute or create derivative works of this material or any part
 * of it without the prior written consent of Monitise Group Limited.
 * Any reproduction of this material must contain this notice.
 */
package net.entrofi.hrm.rest.resources;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;

/**
 * TODO add javadoc
 * Created on 15/12/2016.
 */
@Configuration
@ComponentScan(basePackages = {"net.entrofi.hrm"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableMongoRepositories("net.entrofi.hrm.domain.repository")
public class ResourceTestConfigurer {

    protected String getDatabaseName() {
        return "hrm_mongo_test";
    }


    @Bean(name = "mongoClient")
    public MongoClient mongoClient() throws Exception {
        return new MongoClient();
    }

    @Bean(name = "mongoTemplate")
    public MongoTemplate mongoTemplate() throws Exception{
        return new MongoTemplate(new SimpleMongoDbFactory(mongoClient(), getDatabaseName()));
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }
}
