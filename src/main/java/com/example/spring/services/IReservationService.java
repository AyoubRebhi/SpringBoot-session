package com.example.spring.services;

import com.example.spring.entity.Reservation;

import java.util.Date;
import java.util.List;

public interface IReservationService {
    public List<Reservation> retrieveAllReservations();
    public Reservation updateReservation(Reservation r);
    public Reservation retrieveReservation(Long idReservation);
    List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversitaire, String nomUniversite);

}
