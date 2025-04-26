package com.example.tp1.services.IMPL;

import com.example.tp1.entity.Bloc;
import com.example.tp1.entity.Chambre;
import com.example.tp1.repository.BlocRepository;
import com.example.tp1.services.interfaces.IblocService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class BlocServiceIMPL implements IblocService {
    BlocRepository blocRepository;
    @Override
    public List<Bloc> retrieveAllBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc addBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public Bloc updateBloc(Bloc c) {
        return blocRepository.save(c);
    }

    @Override
    public Bloc retrieveBloc(long idBloc) {
        return blocRepository.findById(idBloc).orElse(null);
    }

    @Override
    public void deleteBloc(long idBloc) {blocRepository.deleteById(idBloc);
    }
    @Override
    public List<Bloc> getBlocByNomUniversite(String nom) {
        return blocRepository.findByFoyerUniversiteNomUniversiteLike(nom);
    }


    
}
