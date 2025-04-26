package com.example.tp1.services.interfaces;

import com.example.tp1.entity.Bloc;

import java.util.List;

public interface IblocService {
    List<Bloc> retrieveAllBlocs();
    Bloc addBloc(Bloc b);
    Bloc updateBloc (Bloc c);
    Bloc retrieveBloc (long idBloc);
    void deleteBloc (long idBloc);
    List <Bloc> getBlocByNomUniversite(String nom);
}
