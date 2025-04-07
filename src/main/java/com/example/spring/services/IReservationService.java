package com.example.spring.services;

import com.example.spring.entity.Reservation;

import java.util.Date;
import java.util.List;

public interface IReservationService {
    List<Reservation> retrieveAllReservation();
    Reservation updateReservation (Reservation res);
    Reservation retrieveReservation (String idReservation);

    List<Reservation> getReservationsByAnneeUniversitaireAndUniversite(Date anneeUniversite, String nomUniversite);

    public Reservation ajouterReservation(long idBloc, long cinEtudiant) ;
    public Reservation annulerReservation(long cinEtudiant);
}
