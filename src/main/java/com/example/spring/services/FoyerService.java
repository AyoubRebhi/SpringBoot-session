package com.example.spring.services;

import com.example.spring.entity.Foyer;
import com.example.spring.entity.Universite;
import com.example.spring.repository.IBlocRepository;
import com.example.spring.repository.IFoyerRepository;
import com.example.spring.repository.IUniversiteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerService implements IFoyerService{

    @Autowired
    IFoyerRepository foyerRepository;
    @Autowired
    IUniversiteRepository universiteRepository;
    @Override
    public List<Foyer> retrieveAllFoyers() {
        return (List<Foyer>) foyerRepository.findAll();
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
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);

        foyer = foyerRepository.save(foyer);
        universite.setFoyer(foyer);

        return foyerRepository.save(foyer);
    }
}
