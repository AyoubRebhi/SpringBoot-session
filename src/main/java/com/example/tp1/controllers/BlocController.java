package com.example.tp1.controllers;

import com.example.tp1.entity.Bloc;
import com.example.tp1.services.interfaces.IblocService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Bloc")
public class BlocController {
     IblocService iblocService;

    @GetMapping("/getAllBlocs")
    public List<Bloc> retrieveAllBlocs() {
        return iblocService.retrieveAllBlocs();
    }
    @DeleteMapping("/delete/{idBloc}")
    public void deleteBloc(@PathVariable long idBloc) {
        iblocService.deleteBloc(idBloc);
    }

    @PostMapping("/addBloc")
    public Bloc addBloc(@RequestBody Bloc b) {
        return iblocService.addBloc(b);
    }

    @PutMapping("/updateBloc")
    public Bloc updateBloc(@RequestBody Bloc c) {
        return iblocService.updateBloc(c);
    }

    @GetMapping("/retrieveBloc/{idBloc}")
    public Bloc retrieveBloc(@PathVariable long idBloc) {
        return iblocService.retrieveBloc(idBloc);
    }
    @GetMapping("/getBlocByNomUniversite/{nom}")
    public List<Bloc> getBlocByNomUniversite(@PathVariable String nom) {
        return iblocService.getBlocByNomUniversite(nom);
    }
}
