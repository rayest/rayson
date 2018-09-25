package org.rayson.docker;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 *  Created with IntelliJ IDEA.
 *  User:  lirui
 *  Date:  2018-09-25
 *  Time: 下午9:29
 *  Description:
 **/
@RestController
public class DockerController {

    @GetMapping(value = "/docker")
    public ResponseEntity docker() {
        String name = "docker";
        return ResponseEntity.ok(name);
    }
}
