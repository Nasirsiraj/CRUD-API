package org.io.crud.controller;

import lombok.extern.slf4j.Slf4j;
import org.io.crud.model.Laptop;
import org.io.crud.service.Laptop_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Laptop_Controller {
    @Autowired
    Laptop_Service laptop_service;

    // get all laptop
    @GetMapping("/laptops")
    public List<Laptop> getLaptopList(){
        return laptop_service.getLaptopList();
    }
    // get one laptop
    @GetMapping("/laptop/{id$}")
    public Laptop getLaptop(@PathVariable int id$){
        return laptop_service.getLaptop(id$);
    }
    // post all laptop
    @PostMapping("/laptops")
    public List<Laptop> postLaptopList(@RequestBody List<Laptop> laptopList$){
        return laptop_service.postLaptopList(laptopList$);
    }
    // post one laptop
    @PostMapping("/laptop")
    public Laptop postLaptop(@RequestBody Laptop laptop$){
        return laptop_service.postLaptop(laptop$);
    }
    // delete laptop by id
    @DeleteMapping("/laptop/{id$}")
    public String deleteLaptop(@PathVariable int id$){
        return laptop_service.deleteLaptop(id$);
    }
    // delete laptop by obj
    @DeleteMapping("/laptop")
    public String deleteLaptop(@RequestBody Laptop laptop$){
        return laptop_service.deleteLaptop(laptop$);
    }
    // update laptop by obj
    @PutMapping("/laptop")
    public Laptop updateLaptop(@RequestBody Laptop laptop$){
        return laptop_service.updateLaptop(laptop$);
    }
}
