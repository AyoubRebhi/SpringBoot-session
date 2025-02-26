package com.example.spring.controller;

import com.example.spring.entity.Bloc;
import com.example.spring.entity.Chambre;
import com.example.spring.repository.IBlocRepository;
import com.example.spring.repository.IChambreRepository;
import com.example.spring.services.IBlocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//GET http://localhost:9000/bloc

@RequestMapping("/bloc")
public class BlocController {
    @Autowired
    IBlocService blocService;

    @GetMapping("/get-all")
    public List<Bloc> getAll(){
        return blocService.retrieveAllBlocs();
    }

    @PostMapping("/add-Bloc")
    public Bloc addBlocs(@RequestBody Bloc bloc){
        return blocService.addBloc(bloc);
    }

    @PutMapping("/update-Bloc")
    public Bloc updateBloc(@RequestBody Bloc f){
        return blocService.updateBloc(f);
    }

    @GetMapping("/get-Bloc/{id}")
    public Bloc getBloc(@PathVariable("id") Long id){
        return blocService.retrieveBloc(id);
    }
    @DeleteMapping("/delete-Bloc/{id}")
    public void removeBloc(@PathVariable("id") Long id){
        blocService.removeBloc(id);
    }

}
