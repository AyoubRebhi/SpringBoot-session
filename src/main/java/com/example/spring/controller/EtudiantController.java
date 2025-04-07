package com.example.spring.controller;

import com.example.spring.entity.Etudiant;
import com.example.spring.services.IEtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
public class EtudiantController {
    @Autowired
    IEtudiantService etudiantService;

    @GetMapping("/getetudiants")
    public List<Etudiant> getEtudiants (){
        return (List<Etudiant>) etudiantService.retrieveAllEtudiants();
    }

    @PostMapping("/addetudiants")
    public List<Etudiant> addEtudiants (@RequestBody List<Etudiant> etudiants){
        return (List<Etudiant>) etudiantService.addEtudiants(etudiants);
    }

    @PutMapping("/updateetudiant")
    public Etudiant updateEtudiant (@RequestBody Etudiant etudiant){
        return etudiantService.updateEtudiant(etudiant);
    }

    @GetMapping("/getetudiant/{id}")
    public Etudiant getEtudiant (@PathVariable("id") long id){
        return etudiantService.retrieveEtudiant(id);
    }

    @DeleteMapping("/removeetudiant/{id}")
    public void removeEtudiant (@PathVariable("id") long id){
        etudiantService.removeEtudiant(id);
    }
}
