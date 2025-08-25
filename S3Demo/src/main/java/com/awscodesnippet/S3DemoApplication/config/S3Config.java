package com.awscodesnippet.S3DemoApplication.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class S3Config {

    @Bean("S3Client")
    @Profile("local")
    public S3Client s3Client(@Value("${cloud.aws.credentials.access-key}") String accessKey,
                             @Value("uTvWQrCZld5gnj3yL9F6MB0MVZuDIU5aSMruuv0x") String secretKey) {
//        AwsBasicCredentials awsBasicCredentials = AwsBasicCredentials.create(accessKey, "uTvWQrCZld5gnj3yL9F6MB0MVZuDIU5aSMruuv0x");
        AwsBasicCredentials awsBasicCredentials = AwsBasicCredentials.create(accessKey,secretKey);
        return S3Client.builder()
                .region(Region.US_EAST_2)
                .credentialsProvider(StaticCredentialsProvider.create(awsBasicCredentials))
                .build();
    }

    @Bean("S3Client")
    @Profile("dev")
    public S3Client s3ClientDev() {
        return S3Client.builder()
                .region(Region.US_EAST_2)
                .credentialsProvider(DefaultCredentialsProvider.create())
                .build();
    }

}
