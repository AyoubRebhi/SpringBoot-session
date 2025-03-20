package com.example.spring.services;

import com.example.spring.entity.Foyer;
import com.example.spring.entity.Universite;
import com.example.spring.repository.IFoyerRepository;
import com.example.spring.repository.IUniversiteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversiteService implements IUniversiteService{
    @Autowired
    IUniversiteRepository universiteRepository;
    @Autowired
    IFoyerRepository foyerRepository; // ✅ Correctly injected

    @Override
    public List<Universite> retrieveAllUniversities() {
        return (List<Universite>) universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite UpdateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversite(Long idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite affecterFoyerAUniversite(long idUniversite, String nomFoyer){
        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(() -> new EntityNotFoundException("Reservation not found with id: " + idUniversite));
        Foyer foyer = foyerRepository.findByNomFoyerJPQL(nomFoyer);
        if (foyer == null) {
            throw new EntityNotFoundException("Foyer introuvable avec le nom: " + nomFoyer);
        }
        universite.setFoyer(foyer);
        universiteRepository.save(universite);
        return universite;
    }
    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(() -> new EntityNotFoundException("Reservation not found with id: " + idUniversite));
        universite.setFoyer(null);
        universiteRepository.save(universite);
        return universite;

    }

}
