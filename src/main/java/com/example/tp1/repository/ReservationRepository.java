package com.example.tp1.repository;

import com.example.tp1.entity.Chambre;
import com.example.tp1.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,String> {

   @Query("SELECT r FROM Reservation r,Chambre  c " +
           "JOIN c.bloc b " +
           "JOIN b.foyer f " +
           "JOIN f.universite u " +
           "WHERE r.anneeUniversitaire = :anneeUniversitaire " +
           "AND u.nomUniversite = :nomUniversite")
   List<Reservation> findByAnneeUniversitaireAndNomUniversite
           (@Param("anneeUniversitaire") LocalDate anneeUniversitaire,
            @Param("nomUniversite") String nomUniversite);

   @Query("SELECT c FROM Chambre c " +
           "LEFT JOIN c.reservations r " +
           "WHERE r.idReservation IS NULL " +
           "OR (r.anneeUniversitaire <> :anneUniversitaire)")
   List<Chambre> findNonReservedChambres(@Param("anneUniversitaire") LocalDate anneUniversitaire);



}
