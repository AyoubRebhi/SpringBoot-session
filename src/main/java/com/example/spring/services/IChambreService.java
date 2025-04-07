package com.example.spring.services;

import com.example.spring.entity.Chambre;
import com.example.spring.entity.TypeChambre;

import java.util.List;

public interface IChambreService {
    List<Chambre> retrieveAllChambres();
    Chambre addChambre(Chambre chambre);
    Chambre updateChambre (Chambre chambre);
    Chambre retrieveChambre (long idChambre);

    List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre type);
    List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC);

    public List<Chambre> getChambresParNomUniversite(String nomUniversite);

}
