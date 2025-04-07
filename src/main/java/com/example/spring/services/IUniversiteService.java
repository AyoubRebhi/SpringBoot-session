package com.example.spring.services;

import com.example.spring.entity.Foyer;
import com.example.spring.entity.Universite;

import java.util.List;

public interface IUniversiteService {
    List<Universite> retrieveAllUniversities();
    Universite addUniversite (Universite u);
    Universite updateUniversite (Universite u);
    Universite retrieveUniversite (long idUniversite);

    public Universite affecterFoyerAUniversite (long idFoyer, String nomUniversite) ;

    public Universite desaffecterFoyerAUniversite (long idUniversite) ;

    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite);

}
