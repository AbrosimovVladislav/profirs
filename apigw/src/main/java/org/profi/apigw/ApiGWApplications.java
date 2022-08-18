package org.profi.apigw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ApiGWApplications {

  public static void main(String[] args) {
    SpringApplication.run(ApiGWApplications.class, args);
  }
}
