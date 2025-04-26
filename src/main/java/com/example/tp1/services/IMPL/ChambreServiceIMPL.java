package com.example.tp1.services.IMPL;

import com.example.tp1.entity.Bloc;
import com.example.tp1.entity.Chambre;
import com.example.tp1.entity.TypeChambre;
import com.example.tp1.repository.BlocRepository;
import com.example.tp1.repository.ChambreRepository;
import com.example.tp1.services.interfaces.IchambreService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ChambreServiceIMPL implements IchambreService {
    ChambreRepository chambreRepository;
    BlocRepository blocRepository;
    @Override
    public List<Chambre> retrieveAllChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre retrieveChambre(long idChambre) {
        return chambreRepository.findById(idChambre).orElse(null);
    }

    @Override
    public List<Chambre> getChambreByAddresseUniversite(String ads) {
        return chambreRepository.findByBlocFoyerUniversiteAdresse(ads);
    }

    @Override
    public Chambre getChambreByCINEtudaintEtNomBloc(Long CIN, String nom) {
        return  chambreRepository.findByReservationsEtudiantsCinAndBlocNomBloc(CIN,nom);
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
        List<Chambre> chambres = chambreRepository.findByNumeroChambreIn(numChambre);
        Bloc bloc = blocRepository.findById(idBloc).orElse(null);
        for (Chambre c : chambres) {
            c.setBloc(bloc);
            chambreRepository.save(c);
        }
        return bloc;
    }

    @Override
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC) {
        return chambreRepository.findByBlocIdBlocAndTypeC(idBloc,typeC);
    }

    @Override
    public List<Chambre> findByBlocIdBlocAndTypeC(long idBloc, TypeChambre typeC) {
        return chambreRepository.findByBlocIdBlocAndTypeC(idBloc, typeC);
    }

    @Override
    public List<Chambre> getChambresParNomUniversite(String nomUniversite) {
        return chambreRepository.getChambresParNomUniversite(nomUniversite);
    }

    @Override
    public List<Chambre> getChambresParNomUniversite2(String nomUniversite) {
        return chambreRepository.findChambreByBlocFoyerUniversiteNomUniversite(nomUniversite);
    }


}
