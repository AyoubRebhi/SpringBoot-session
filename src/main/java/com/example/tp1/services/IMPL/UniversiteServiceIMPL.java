package com.example.tp1.services.IMPL;

import com.example.tp1.entity.Foyer;
import com.example.tp1.entity.Universite;
import com.example.tp1.repository.FoyerRepository;
import com.example.tp1.repository.UniversiteRepository;
import com.example.tp1.services.interfaces.IuniversiteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UniversiteServiceIMPL implements IuniversiteService {
    UniversiteRepository universiteRepository;
FoyerRepository foyerRepository;
    @Override
    public List<Universite> retrieveAllUniversities() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversite(long idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null);
    }

    @Override
    public Universite getUniversiteByCapacityBlocEtCapacityFoyer(Long capacityBloc, Long capacityFoyer) {
        return universiteRepository.findByFoyerBlocsCapaciteBlocAndFoyerCapaciteFoyer( capacityBloc,capacityFoyer);
    }

    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Foyer f =foyerRepository.findById(idFoyer).orElse(null);
        Universite u=universiteRepository.findByNomUniversite(nomUniversite);
        u.setFoyer(f);
        return universiteRepository.save(u);
    }

    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
       Universite u=universiteRepository.findById(idUniversite).orElse(null);
        assert u != null;
        u.setFoyer(null);
       return universiteRepository.save(u);
    }
}
