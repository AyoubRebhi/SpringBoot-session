package com.example.tp1.controllers;

import com.example.tp1.entity.Foyer;
import com.example.tp1.entity.TypeChambre;
import com.example.tp1.services.interfaces.IfoyerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Foyer")
public class FoyerController {

     IfoyerService ifoyerService;

    @GetMapping("/getAllFoyers")
    public List<Foyer> retrieveAllFoyers() {
        return ifoyerService.retrieveAllFoyers();
    }

    @PostMapping("/addFoyer")
    public Foyer addFoyer(@RequestBody Foyer f) {
        return ifoyerService.addFoyer(f);
    }

    @PutMapping("/updateFoyer")
    public Foyer updateFoyer(@RequestBody Foyer f) {
        return ifoyerService.updateFoyer(f);
    }

    @GetMapping("/retrieveFoyer/{idFoyer}")
    public Foyer retrieveFoyer(@PathVariable long idFoyer) {
        return ifoyerService.retrieveFoyer(idFoyer);
    }

    @DeleteMapping("/removeFoyer/{idFoyer}")
    public void removeFoyer(@PathVariable long idFoyer) {
        ifoyerService.removeFoyer(idFoyer);
    }

    @GetMapping("/getFoyerByTypeChambreEtNomBloc")
    public Foyer getFoyerTypeChambreEtNomBloc(@RequestParam TypeChambre typec, @RequestParam String nom) {
        return ifoyerService.getFoyerTypeChambreEtNomBloc(typec, nom);
    }
@PostMapping("ajouterFoyerEtAffecterAUniversite/{idUniversite}")
    public Foyer ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer foyer, @PathVariable long idUniversite) {
        return ifoyerService.ajouterFoyerEtAffecterAUniversite(foyer, idUniversite);
    }
}
