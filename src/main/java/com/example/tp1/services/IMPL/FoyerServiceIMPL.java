package com.example.tp1.services.IMPL;

import com.example.tp1.entity.Bloc;
import com.example.tp1.entity.Foyer;
import com.example.tp1.entity.TypeChambre;
import com.example.tp1.entity.Universite;
import com.example.tp1.repository.BlocRepository;
import com.example.tp1.repository.FoyerRepository;
import com.example.tp1.repository.UniversiteRepository;
import com.example.tp1.services.interfaces.IfoyerService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerServiceIMPL implements IfoyerService {
    FoyerRepository foyerRepository;
    BlocRepository blocRepository;
    UniversiteRepository universiteRepository;

    @Override
    public List<Foyer> retrieveAllFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer retrieveFoyer(long idFoyer) {
        return foyerRepository.findById(idFoyer).orElse(null);
    }

    @Override
    public void removeFoyer(long idFoyer) {
foyerRepository.deleteById(idFoyer);
    }

    @Override
    public Foyer getFoyerTypeChambreEtNomBloc(TypeChambre typec, String nom) {
        return null;
    }

    @Override
    @Transactional //njmo nahiw .save car transc va faire ca
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        foyerRepository.save(foyer);//ajout foyer+blocs sans affectation
        for(Bloc b :foyer.getBlocs()){
            b.setFoyer(foyer);
            blocRepository.save(b); //affectation blocs aux foyer
        }
        //affecter foyer au universite
        Universite u=universiteRepository.findById(idUniversite).orElse(null);
        assert u != null;
        u.setFoyer(foyer);
        return foyer;
    }
}
