package com.example.spring.services;

import com.example.spring.entity.Foyer;

import java.util.List;

public interface IFoyerService {
    public List<Foyer> retrieveAllFoyers();
    public Foyer addFoyer(Foyer f);
    public Foyer updateFoyer(Foyer f);
    public Foyer retrieveFoyer(Long idFoyer);
    public void removeFoyer(Long idFoyer);
}
