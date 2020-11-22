package org.io.crud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
@Slf4j
@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Default_Controller {
    @RequestMapping("/")
    public String getDefaultPage(){
        return "index.html";
    }
}
