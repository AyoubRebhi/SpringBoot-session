package com.example.tp1.controllers;

import com.example.tp1.entity.Etudiant;
import com.example.tp1.services.interfaces.IetudiantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Etudiant")
public class EtudiantController {

     IetudiantService ietudiantService;

    @GetMapping("/getAllEtudiants")
    public List<Etudiant> retrieveAllEtudiants() {
        return ietudiantService.retrieveAllEtudiants();
    }

    @PostMapping("/addEtudiants")
    public List<Etudiant> addEtudiants(@RequestBody List<Etudiant> etudiants) {
        return ietudiantService.addEtudiants(etudiants);
    }

    @PutMapping("/updateEtudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant e) {
        return ietudiantService.updateEtudiant(e);
    }

    @GetMapping("/retrieveEtudiant/{idEtudiant}")
    public Etudiant retrieveEtudiant(@PathVariable long idEtudiant) {
        return ietudiantService.retrieveEtudiant(idEtudiant);
    }

    @DeleteMapping("/removeEtudiant/{idEtudiant}")
    public void removeEtudiant(@PathVariable long idEtudiant) {
        ietudiantService.removeEtudiant(idEtudiant);
    }
}
