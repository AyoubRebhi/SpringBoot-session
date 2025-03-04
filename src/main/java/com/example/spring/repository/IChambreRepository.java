package com.example.spring.repository;

import com.example.spring.entity.Chambre;
import com.example.spring.entity.TypeChambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IChambreRepository extends CrudRepository<Chambre,Long> {
    @Query("SELECT c FROM Chambre c " +
            "JOIN c.bloc b JOIN b.foyer f JOIN f.universite u " +
            "WHERE u.nomUniversite = :nomUniversite " +
            "AND c.typeC = :type " +
            "AND c NOT IN (SELECT r.chambre FROM Reservation r WHERE r.anneeUniversitaire = FUNCTION('YEAR', CURRENT_DATE))")
    List<Chambre> findChambresNonReservees(String nomUniversite, TypeChambre type);
}
