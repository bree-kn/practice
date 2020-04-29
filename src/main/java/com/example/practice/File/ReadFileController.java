package com.example.practice.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ReadFileController {

    @Autowired
    private ReadService readService;

    @RequestMapping("/read")
    public void read() throws IOException {
        readService.read();
    }
}
