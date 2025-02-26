package com.example.spring.controller;

import com.example.spring.entity.Foyer;
import com.example.spring.services.IFoyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foyer")

public class FoyerController {
    @Autowired
    IFoyerService foyerService;

    @GetMapping("/get-all")
    public List<Foyer> getAll(){
        return foyerService.retrieveAllFoyers();
    }

    @PostMapping("/add-foyer")
    public Foyer addFoyer(@RequestBody Foyer f){
        return foyerService.addFoyer(f);
    }

    @PutMapping("/update-foyer")
    public Foyer updateFoyer(@RequestBody Foyer f){
        return foyerService.updateFoyer(f);
    }

    @GetMapping("/get-foyer/{id}")
    public Foyer getFoyer(@PathVariable("id") Long id){
        return foyerService.retrieveFoyer(id);
    }
    @DeleteMapping("/delete-foyer/{id}")
    public void removeFoyer(@PathVariable("id") Long id){
        foyerService.removeFoyer(id);
    }
}
