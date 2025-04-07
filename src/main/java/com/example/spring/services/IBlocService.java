package com.example.spring.services;

import com.example.spring.entity.Bloc;

import java.util.List;

public interface IBlocService {
    List<Bloc> retrieveBlocs();
    Bloc updateBloc (Bloc bloc);
    Bloc addBloc (Bloc bloc);
    Bloc retrieveBloc (long idBloc);
    void removeBloc (long idBloc);

    public Bloc affecterChambresABloc(List<Long> numChambres, long idBloc);

}