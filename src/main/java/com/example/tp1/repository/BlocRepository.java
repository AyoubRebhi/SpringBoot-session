package com.example.tp1.repository;

import com.example.tp1.entity.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlocRepository extends JpaRepository<Bloc,Long> {
    List<Bloc> findByFoyerUniversiteNomUniversiteLike(String nom);
}
