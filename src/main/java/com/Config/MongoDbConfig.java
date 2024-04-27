package com.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
@EnableMongoRepositories(basePackages = "com.repository")
public class MongoDbConfig extends AbstractMongoClientConfiguration {

  @Value("${spring.data.mongodb.uri}")
  private String mongoDbUri;

  @Value("${spring.data.mongodb.database}")
  private String mongoDbName;

  @Override
  protected String getDatabaseName() {
    if (mongoDbName == null)
      throw new IllegalStateException("MongoDB database name is not set");
    try {
      return mongoDbName;
    } catch (Exception e) {
      throw new IllegalStateException("MongoDB database name is not set");
    }
  }

  @Override
  public MongoClient mongoClient() {
    try {
      MongoClient client = MongoClients.create(mongoDbUri);
      return client;
    } catch (Exception e) {
      throw new RuntimeException("Failed to create MongoDB client", e);
    }
  }
}