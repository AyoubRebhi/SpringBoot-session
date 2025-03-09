package com.example.spring.controller;

import com.example.spring.entity.Bloc;
import com.example.spring.entity.Chambre;
import com.example.spring.repository.IBlocRepository;
import com.example.spring.repository.IChambreRepository;
import com.example.spring.services.IBlocService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Bloc Management", description = "APIs for managing blocs")
@RestController
//GET http://localhost:9000/bloc
@RequestMapping("/api/bloc")
public class BlocController {
    @Autowired
    IBlocService blocService;

    @GetMapping("/get-all")
    public List<Bloc> getAll(){
        return blocService.retrieveAllBlocs();
    }

    @PostMapping
    public Bloc addBloc(@RequestBody Bloc bloc) {
        return blocService.addBloc(bloc);
    }

    @PutMapping("/{id}")
    public Bloc updateBloc(@PathVariable("id") Long id, @RequestBody Bloc bloc) {
        bloc.setIdBloc(id);
        return blocService.updateBloc(bloc);
    }

    @GetMapping("/{id}")
    public Bloc getBloc(@PathVariable("id") Long id) {
        return blocService.retrieveBloc(id);
    }

    @DeleteMapping("/{id}")
    public void removeBloc(@PathVariable("id") Long id) {
        blocService.removeBloc(id);
    }
}
