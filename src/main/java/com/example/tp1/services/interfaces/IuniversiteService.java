package com.example.tp1.services.interfaces;

import com.example.tp1.entity.Universite;

import java.util.List;

public interface IuniversiteService {
    List<Universite> retrieveAllUniversities();
    Universite addUniversite (Universite u);
    Universite updateUniversite (Universite u);
    Universite retrieveUniversite (long idUniversite);
    Universite getUniversiteByCapacityBlocEtCapacityFoyer(Long capacityBloc,Long capacityFoyer);
     Universite affecterFoyerAUniversite (long idFoyer, String
            nomUniversite) ;
    public Universite desaffecterFoyerAUniversite (long idUniversite) ;
}
