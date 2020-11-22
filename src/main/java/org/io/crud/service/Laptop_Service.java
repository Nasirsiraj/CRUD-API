package org.io.crud.service;

import org.io.crud.model.Laptop;
import org.io.crud.repository.Laptop_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
@Service
public class Laptop_Service {
    @Autowired
    Laptop_Repository laptop_repository;

    // get all laptop
    public List<Laptop> getLaptopList(){
        return laptop_repository.findAll();
    }
    // get laptop by id
    public Laptop getLaptop(@Validated int id$){
        return laptop_repository.findById(id$).orElse(null);
    }
    // post all laptop
    public List<Laptop> postLaptopList(@Validated List<Laptop> laptopList$){
        return laptop_repository.saveAll(laptopList$);
    }
    // post one laptop
    public Laptop postLaptop(@Validated Laptop laptop$){
        return laptop_repository.save(laptop$);
    }
    // delete laptop by id
    public String deleteLaptop(@Validated int id$){
        Laptop laptop$$ = laptop_repository.findById(id$).orElse(null);
        if(laptop$$ != null){
            laptop_repository.deleteById(id$);
            return "laptop deleted, id: "+id$+".";
        }else{
            return "laptop not found!";
        }
    }
    // delete laptop by obj
    public String deleteLaptop(@Validated Laptop laptop$){
        Laptop laptop$$ = laptop_repository.findById(laptop$.getId()).orElse(null);
        if (laptop$$ != null){
            laptop_repository.delete(laptop$);
            return "laptop deleted, id: "+laptop$.getId();
        }else {
            return "laptop not found!";
        }
    }
    // update laptop obj
    public Laptop updateLaptop(@Validated Laptop laptop$){
        Laptop laptop$$ = laptop_repository.findById(laptop$.getId()).orElse(null);
        if(laptop$$ != null){
            laptop$$.setBrandName(laptop$.getBrandName());
            laptop$$.setRam(laptop$.getRam());
            laptop$$.setRom(laptop$.getRom());
            laptop$$.setHardDisk(laptop$.getHardDisk());
            laptop$$.setPrice(laptop$.getPrice());

            return laptop_repository.save(laptop$$);
        }else{
            return null;
        }
    }
}

