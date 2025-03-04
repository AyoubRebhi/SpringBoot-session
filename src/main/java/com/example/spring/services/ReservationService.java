package com.example.spring.services;

import com.example.spring.entity.Reservation;
import com.example.spring.repository.IReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReservationService implements IReservationService{
    @Autowired
    IReservationRepository reservationRepository;
    @Override
    public List<Reservation> retrieveAllReservations() {
        return (List<Reservation>) reservationRepository.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    @Override
    public Reservation retrieveReservation(Long idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }

    @Override
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversitaire, String nomUniversite) {
        return reservationRepository.findReservationsByAnneeUniversitaireAndNomUniversite(anneeUniversitaire, nomUniversite);

    }

}
