package com.example.spring.services;

import com.example.spring.entity.Bloc;

import java.util.List;

public interface IBlocService {
    public List<Bloc> retrieveAllBlocs();
    public Bloc updateBloc(Bloc bloc);
    public Bloc addBloc(Bloc bloc);
    public Bloc retrieveBloc(Long idBloc);
    public void removeBloc(Long idBloc);
}