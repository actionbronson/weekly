package org.weekly.store;

import de.bwaldvogel.mongo.MongoServer;
import de.bwaldvogel.mongo.backend.memory.MemoryBackend;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.weekly.security.WeeklyUserFactory;

import java.net.InetSocketAddress;

@Configuration
@ComponentScan(basePackageClasses = {WeeklyUserFactory.class})
@EnableMongoRepositories(basePackageClasses={UserRepository.class})
public class MongoRepositoryTestConfiguration {

    @Bean(destroyMethod = "shutdown")
    public MongoServer mongoServer() {
        MongoServer mongoServer = new MongoServer(new MemoryBackend());
        mongoServer.bind();
        return mongoServer;
    }

    @Bean
    public MongoDbFactory mongoDbFactory(MongoServer mongoServer) {
        InetSocketAddress serverAddress = mongoServer.getLocalAddress();
        return new SimpleMongoClientDbFactory("mongodb://" + serverAddress.getHostName() + ":" + serverAddress.getPort() + "/test");
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory) {
        return new MongoTemplate(mongoDbFactory);
    }
}
