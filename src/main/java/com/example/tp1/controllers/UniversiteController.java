package com.example.tp1.controllers;

import com.example.tp1.entity.Universite;
import com.example.tp1.services.interfaces.IuniversiteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Universite")
public class UniversiteController {

    IuniversiteService iuniversiteService;

    @GetMapping("/getAllUniversites")
    public List<Universite> retrieveAllUniversities() {
        return iuniversiteService.retrieveAllUniversities();
    }

    @PostMapping("/addUniversite")
    public Universite addUniversite(@RequestBody Universite u) {
        return iuniversiteService.addUniversite(u);
    }

    @PutMapping("/updateUniversite")
    public Universite updateUniversite(@RequestBody Universite u) {
        return iuniversiteService.updateUniversite(u);
    }

    @GetMapping("/retrieveUniversite/{idUniversite}")
    public Universite retrieveUniversite(@PathVariable long idUniversite) {
        return iuniversiteService.retrieveUniversite(idUniversite);
    }

    @GetMapping("/getUniversiteByCapacityBlocEtCapacityFoyer")
    public Universite getUniversiteByCapacityBlocEtCapacityFoyer(
            @RequestParam Long capacityBloc,
            @RequestParam Long capacityFoyer) {
        return iuniversiteService.getUniversiteByCapacityBlocEtCapacityFoyer(capacityBloc, capacityFoyer);
    }
    @GetMapping("/affecterFoyerUniversite/{idFoyer}/{nomUniversite}")
    public Universite affecterFoyerAUniversite(@PathVariable long idFoyer, @PathVariable String nomUniversite) {
        return iuniversiteService.affecterFoyerAUniversite(idFoyer, nomUniversite);
    }

    @PutMapping("deacffecter/{idUniversite}")
    public Universite desaffecterFoyerAUniversite( @PathVariable long idUniversite) {
        return iuniversiteService.desaffecterFoyerAUniversite(idUniversite);
    }
}
