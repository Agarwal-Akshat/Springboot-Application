package myPackage.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class Controller3 {

    private static final Logger LOGGER = LoggerFactory.getLogger(Controller3.class);

    private static final String MAIN_SERVICE = "mainService";

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


    @GetMapping("/circuitTest")
    @ResponseStatus(HttpStatus.OK)
    @CircuitBreaker(name = MAIN_SERVICE)
    public ResponseEntity<String> getSleuthTest(){
        LOGGER.info("I'm here in main service calling service one");
        String response = restTemplate.getForObject("http://localhost:8082/home", String.class);
        return new ResponseEntity<String>(response, HttpStatus.OK);

    }

}