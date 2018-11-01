package com.nibado.example.springtestcontainers;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoDBConfig {
    @Value("${aws.region}")
    private String region;

    @Value("${aws.dynamo.endpoint}")
    private String dynamoEndpoint;

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        return  AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(dynamoEndpoint, region))
                .withCredentials(new DefaultAWSCredentialsProviderChain())
                .build();
    }
}
