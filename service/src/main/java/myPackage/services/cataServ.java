package myPackage.services;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import myPackage.db.catalogue;
import myPackage.db.catalogueRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class cataServ {


    private static final Logger LOGGER = LoggerFactory.getLogger(cataServ.class);

    private static final String MAIN_SERVICE = "mainService";

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @CircuitBreaker(name = MAIN_SERVICE, fallbackMethod = "fallbackCircuit")
    @RateLimiter(name = MAIN_SERVICE)
    public ResponseEntity<String> circuitTest(){
        LOGGER.info("I'm here in main service to test circuit break");
        String response = restTemplate.getForObject("http://localhost:8082/home", String.class);
        return new ResponseEntity<String>(response, HttpStatus.OK);

    }
    public ResponseEntity<String> fallbackCircuit(Throwable t){
        LOGGER.error("Inside fallback because: "+t.toString());
        return new ResponseEntity<String>("fallback method",HttpStatus.TOO_MANY_REQUESTS);
    }


    @Autowired
    catalogueRepo crepo;

    final Map<Long,catalogue> mp=new HashMap<>();

    public catalogue findByCustId(long custid){
        if(mp.containsKey(custid)){
            return mp.get(custid);
        }
        else {
            mp.put(custid, crepo.findByCustid(custid));
            return crepo.findByCustid(custid);
        }
    }
}
