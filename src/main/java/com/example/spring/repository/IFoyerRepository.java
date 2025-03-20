package com.example.spring.repository;

import com.example.spring.entity.Foyer;
import com.example.spring.entity.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFoyerRepository extends CrudRepository<Foyer,Long> {

    List<Foyer> findByUniversiteNomUniversite(String nom);
    List<Foyer> findByBlocsNomBloc(String nom);
    List<Foyer> findByUniversiteNomUniversiteAndBlocsNomBloc(String nomU, String nomB);

    Foyer findByNomFoyer(String nomFoyer);
    @Query("SELECT f FROM Foyer f WHERE f.nomFoyer = :nomFoyer")
    Foyer findByNomFoyerJPQL(@Param("nomFoyer") String nomFoyer);
}
