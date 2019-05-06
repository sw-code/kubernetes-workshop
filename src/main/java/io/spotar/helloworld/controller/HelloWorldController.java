package io.spotar.helloworld.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Viktor Gottfried
 */
@RestController
public class HelloWorldController {

    private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @GetMapping("/")
    public ResponseEntity<String> hello() {
        logger.info("Lets say hello");

        return ResponseEntity.ok("Hello World!");
    }
}
