package com.example.tp1.services.interfaces;

import com.example.tp1.entity.Etudiant;

import java.util.List;

public interface IetudiantService  {
    List<Etudiant> retrieveAllEtudiants();
    List<Etudiant> addEtudiants (List<Etudiant> etudiants);
    Etudiant updateEtudiant (Etudiant e);
    Etudiant retrieveEtudiant(long idEtudiant);
    void removeEtudiant(long idEtudiant);

}
