package myPackage.Controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import myPackage.services.cataServ;

@Api(value = "Endpoints for circuitbreaker", description = "Endpoints for circuitbreaker")
@RestController
public class Controller3 {

    @Autowired
    cataServ cs;

    @GetMapping("/circuitTester")
    public ResponseEntity<String> circuitTest() {
        return cs.circuitTest();
    }

}