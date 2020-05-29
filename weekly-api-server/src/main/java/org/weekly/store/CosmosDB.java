package org.weekly.store;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
@Profile("cosmosdb")
public class CosmosDB {
    @Value("${weekly.store.cosmos.database}")
    private String database;

    @Bean
    public MongoClient getMongoClient(@Value("${CUSTOMCONNSTR_CosmosMongoDB}") String uriStr) {
        return MongoClients.create(uriStr);
    }

    @Bean
    public MongoTemplate getMongoTemplate(@Autowired MongoClient client) {
        return new MongoTemplate(client, database);
    }
}
