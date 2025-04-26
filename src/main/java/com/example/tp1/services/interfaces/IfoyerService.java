package com.example.tp1.services.interfaces;

import com.example.tp1.entity.Foyer;
import com.example.tp1.entity.TypeChambre;
import com.example.tp1.entity.Universite;

import java.util.List;

public interface IfoyerService {
    List<Foyer> retrieveAllFoyers();
    Foyer addFoyer (Foyer f);
    Foyer updateFoyer (Foyer f);
    Foyer retrieveFoyer (long idFoyer);
    void removeFoyer (long idFoyer);
    Foyer getFoyerTypeChambreEtNomBloc(TypeChambre typec, String nom);
     Foyer ajouterFoyerEtAffecterAUniversite (Foyer foyer, long idUniversite) ;

}
