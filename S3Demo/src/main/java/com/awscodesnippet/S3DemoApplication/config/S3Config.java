package com.awscodesnippet.S3DemoApplication.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class S3Config {
    @Value("${cloud.aws.credentials.access-key}")
    private String accessKey;

    @Value("uTvWQrCZld5gnj3yL9F6MB0MVZuDIU5aSMruuv0x")
    private String secretKey;

    @Bean
    public S3Client s3Client() {
//        AwsBasicCredentials awsBasicCredentials = AwsBasicCredentials.create(accessKey, "uTvWQrCZld5gnj3yL9F6MB0MVZuDIU5aSMruuv0x");
        AwsBasicCredentials awsBasicCredentials = AwsBasicCredentials.create(accessKey,secretKey);
        return S3Client.builder()
                .region(Region.US_EAST_2)
                .credentialsProvider(StaticCredentialsProvider.create(awsBasicCredentials))
                .build();
    }


}
