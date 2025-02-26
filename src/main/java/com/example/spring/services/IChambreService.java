package com.example.spring.services;

import com.example.spring.entity.Chambre;

import java.util.List;

public interface IChambreService {
    public List<Chambre> retrieveAllChambres();
    public Chambre addChambre(Chambre c);
    public Chambre updateChambre(Chambre c);
    public Chambre retrieveChambre(Long idChambre) ;
}
