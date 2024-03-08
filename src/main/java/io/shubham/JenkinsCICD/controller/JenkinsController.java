package io.shubham.JenkinsCICD.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/jenkins")
public class JenkinsController {

    @GetMapping("/{name}")
    public ResponseEntity<?> getDemoResponse(@PathVariable String name) {
        String result = "Hello " + name + ", Good to see you !";
        return ResponseEntity.ok(result);
    }
}
