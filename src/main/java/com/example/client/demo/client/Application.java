package com.example.client.demo.client;

import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Configuration
@PropertySource("classpath:application.properties")
public class Application implements CommandLineRunner {

    private static final Logger LOGGER = Logger.getLogger(Application.class.getName());

    //final String url = "http://localhost:8080/test";
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Value("${client}")
    String url;

    @Override
    public void run(String... args) throws Exception {

        LOGGER.info("EXECUTING : command line runner");
        RestTemplate restTemplate = new RestTemplate();
        LOGGER.info("URL : " + url);

        if (url.equals("")) {
            LOGGER.info("WS URL NOT PROVIDED !");
        } else {
            while (true) {
                String res = restTemplate.getForObject(url, String.class);
                LOGGER.info(res);
                Thread.sleep(1000);
            }
        }
    }

}
