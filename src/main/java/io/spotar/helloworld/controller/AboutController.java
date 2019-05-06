package io.spotar.helloworld.controller;

import io.spotar.helloworld.resource.AboutResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Viktor Gottfried
 */
@RestController
public class AboutController {

    private final AboutResource aboutResource;

    public AboutController(@Value("${appname}") String appName,
                           @Value("${appversion}") String appVersion) {
        aboutResource = new AboutResource(appName, appVersion);
    }

    @GetMapping("/about")
    public ResponseEntity<AboutResource> about() {
        return ResponseEntity.ok(aboutResource);
    }
}
