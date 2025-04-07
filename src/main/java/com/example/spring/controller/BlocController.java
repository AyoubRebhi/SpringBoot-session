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

    @GetMapping("/getblocs")
    public List<Bloc> getBlocs (){
        return (List<Bloc>) blocService.retrieveBlocs();
    }

    @PostMapping("/addbloc")
    public Bloc addBloc (@RequestBody Bloc bloc){
        return blocService.addBloc(bloc);
    }

    @PutMapping("/updatebloc")
    public Bloc updateBloc (@RequestBody Bloc bloc){
        return blocService.updateBloc(bloc);
    }

    @GetMapping("/getbloc/{id}")
    public Bloc getBloc (@PathVariable("id") long id){
        return blocService.retrieveBloc(id);
    }

    @DeleteMapping("/removebloc/{id}")
    public void removeBloc (@PathVariable("id") long id){
        blocService.removeBloc(id);
    }


    @PostMapping("/affecter-chambres/{idBloc}")
    public Bloc affecterChambresABloc(@RequestBody List<Long> numChambres, @PathVariable long idBloc) {
        return blocService.affecterChambresABloc(numChambres, idBloc);
    }

}
