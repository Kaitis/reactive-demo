package com.example.reactiveDemo.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

/**
 * Created by andreaskaitis on 26/10/2017.
 * reactive-demo
 */

@EnableReactiveMongoRepositories
@AutoConfigureAfter(EmbeddedMongoAutoConfiguration.class)
public class AppConfig extends AbstractReactiveMongoConfiguration {

    @Override
    public MongoClient reactiveMongoClient() {
        return mongoClient();
    }


    @Bean
    @DependsOn("embeddedMongoServer")
    public MongoClient mongoClient() {
        int port = 27017;
        return MongoClients.create(String.format("mongodb://localhost:%d", port));
    }
    @Override
    protected String getDatabaseName() {
        return "reactive-mongo";
    }
}