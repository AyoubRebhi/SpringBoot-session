package com.example.spring.services;

import com.example.spring.entity.Etudiant;
import com.example.spring.repository.IEtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantService implements IEtudiantService{

    @Autowired
    IEtudiantRepository etudiantRepository ;
    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return (List<Etudiant>) etudiantRepository.findAll();
    }

    @Override
    public List<Etudiant> addEtudiants(List<Etudiant> etudiants) {
        return (List<Etudiant>) etudiantRepository.saveAll(etudiants);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).orElse(null);
    }

    @Override
    public void removeEtudiant(long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }
}
