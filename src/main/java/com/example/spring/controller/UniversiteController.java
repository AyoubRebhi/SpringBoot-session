package com.example.spring.controller;

import com.example.spring.entity.Universite;
import com.example.spring.services.IUniversiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/universite")
public class UniversiteController {
    @Autowired
    IUniversiteService universiteService;

    @PostMapping("/add-universite")
    public Universite addUniversite(@RequestBody Universite u){
        return universiteService.addUniversite(u);
    }

    @GetMapping("/get-all")
    public List<Universite> retrieveAll(){
        return universiteService.retrieveAllUniversities();
    }

    @PutMapping("/update")
    public Universite updateUniversite(@RequestBody  Universite u ){
        return universiteService.updateUniversite(u);
    }

    @GetMapping("/find/{id}")
    public Universite retrieveUniversite(@PathVariable("id") Long id)
    {
        return universiteService.retrieveUniversite(id);
    }

    @PutMapping("/affecter-universite/{idUniversite}")
    public Universite affectUniversite(@PathVariable("idUniversite") long idUniversite, @RequestBody Map<String, String> request) {
        String nomFoyer = request.get("nomFoyer");  // Extract "nomFoyer" from JSON body
        return universiteService.affecterFoyerAUniversite(idUniversite, nomFoyer);
    }

    @PutMapping("/desaffecter-universite/{idUniversite}")
    public Universite desaffectUniversite(@PathVariable("idUniversite") long e) {
        return universiteService.desaffecterFoyerAUniversite(e);
    }


}
