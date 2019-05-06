package io.spotar.helloworld.controller;

import io.spotar.helloworld.resource.FileResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Viktor Gottfried
 */
@RestController
public class FileSystemListingController {


    @GetMapping("/data")
    public ResponseEntity<List<FileResource>> lsData() {
        File [] files = new File("/opt/data").listFiles();

        List<FileResource> fileResources;
        if(files == null) {
            fileResources = new ArrayList<>();
        }
        else {
            fileResources = Arrays.stream(files)
                    .map(file -> new FileResource(file.getName()))
                    .collect(Collectors.toList());
        }

        return ResponseEntity.ok(fileResources);
    }
}
