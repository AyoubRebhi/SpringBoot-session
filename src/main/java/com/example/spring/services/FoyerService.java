package com.example.spring.services;

import com.example.spring.entity.Foyer;
import com.example.spring.repository.IBlocRepository;
import com.example.spring.repository.IFoyerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerService implements IFoyerService{

    @Autowired
    IFoyerRepository foyerRepository;


    @Override
    public List<Foyer> retrieveAllFoyers() {
            List<Foyer> all = (List<Foyer>) foyerRepository.findAll();
        return all;
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer retrieveFoyer(Long idFoyer) {
        return foyerRepository.findById(idFoyer).orElse(null);
    }

    @Override
    public void removeFoyer(Long idFoyer) {
        foyerRepository.deleteById(idFoyer);
    }
}
