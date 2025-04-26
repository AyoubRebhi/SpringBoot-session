package com.example.tp1.services.IMPL;

import com.example.tp1.entity.Etudiant;
import com.example.tp1.repository.EtudiantRepository;
import com.example.tp1.services.interfaces.IetudiantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class EtudiantServiceIMPL implements IetudiantService {
    EtudiantRepository etudiantRepository;
    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public List<Etudiant> addEtudiants(List<Etudiant> etudiants) {
        return etudiantRepository.saveAll(etudiants);
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
