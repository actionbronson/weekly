package org.weekly.store;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
@Profile("cosmosdb")
public class CosmosDB extends AbstractMongoClientConfiguration {
    @Value("${weekly.store.cosmos.database}")
    private String database;

    @Value("${CUSTOMCONNSTR_CosmosMongoDB}")
    private String uriStr;

    @Override
    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create(uriStr);
    }

    @Bean
    public MongoTransactionManager mongoTransactionManager(MongoDbFactory factory) {
        return new MongoTransactionManager(factory);
    }

    @Override
    protected String getDatabaseName() {
        return database;
    }
}
