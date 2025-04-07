package com.example.spring.controller;

import com.example.spring.entity.Chambre;
import com.example.spring.entity.TypeChambre;
import com.example.spring.services.IChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chambre")
public class ChambreController {
    @Autowired
    IChambreService chambreService;

    @GetMapping("/getchambres")
    public List<Chambre> getChambres (){

        return (List<Chambre>) chambreService.retrieveAllChambres();
    }

    @PostMapping("/addchambre")
    public Chambre addChambre (@RequestBody Chambre chambre){
        return chambreService.addChambre(chambre);
    }

    @PutMapping("/updatechambre")
    public Chambre updateChambre (@RequestBody Chambre chambre){
        return chambreService.updateChambre(chambre);
    }

    @GetMapping("/getchambre/{id}")
    public void getChambre (@PathVariable("id") long id){
        chambreService.retrieveChambre(id);
    }


    @GetMapping("/nonReservees")
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(
            @RequestParam String nomUniversite,
            @RequestParam TypeChambre type) {
        return chambreService.getChambresNonReserveParNomUniversiteEtTypeChambre(nomUniversite, type);
    }

    @GetMapping("/bloc&type")
    public List<Chambre> getChambresParBlocEtType(
            @RequestParam long idBloc,
            @RequestParam TypeChambre typeC) {
        return chambreService.getChambresParBlocEtType(idBloc, typeC);
    }

    @GetMapping("/universite/{nomUniversite}")
    public List<Chambre> getChambresParNomUniversite(@PathVariable String nomUniversite) {
        return chambreService.getChambresParNomUniversite(nomUniversite);
    }

}
