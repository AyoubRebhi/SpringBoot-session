package com.example.spring.services;

import com.example.spring.entity.Universite;

import java.util.List;

public interface IUniversiteService {
    public List<Universite> retrieveAllUniversities();
    public Universite addUniversite(Universite u);
    public Universite UpdateUniversite(Universite u);
    public Universite retrieveUniversite(Long idUniversite);

    public Universite updateUniversite(Universite u);
    Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) ;
    Universite desaffecterFoyerAUniversite (long idUniversite) ;

}
