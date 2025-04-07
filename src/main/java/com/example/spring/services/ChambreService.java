package com.example.spring.services;

import com.example.spring.entity.Chambre;
import com.example.spring.entity.TypeChambre;
import com.example.spring.repository.IChambreRepository;
import com.example.spring.repository.IUniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChambreService implements IChambreService {
    @Autowired
    IChambreRepository chambreRepository;

    @Autowired
    IUniversiteRepository universiteRepository;

    @Override
    public List<Chambre> retrieveAllChambres() {
        return (List<Chambre>) chambreRepository.findAll();
    }

    @Override
    public Chambre addChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public Chambre updateChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public Chambre retrieveChambre(long idChambre) {
        return chambreRepository.findById(idChambre).orElse(null);
    }

    @Override
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre type) {
        return chambreRepository.findChambresNonReservees(nomUniversite , type);
    }

    @Override
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC) {
        return chambreRepository.findByBlocIdBlocAndTypeC(idBloc ,typeC);
    }

    @Override
    public List<Chambre> getChambresParNomUniversite(String nomUniversite) {
        System.out.println("🔍 Recherche des chambres pour l'université: " + nomUniversite);

        List<Chambre> chambres = chambreRepository.findByNomUniversite(nomUniversite);

        if (chambres.isEmpty()) {
            throw new RuntimeException("Aucune chambre trouvée pour l'université: " + nomUniversite);
        }

        System.out.println("✅ Nombre de chambres trouvées: " + chambres.size());

        return chambres;
    }


}
