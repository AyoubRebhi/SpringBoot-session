package com.example.spring.repository;

import com.example.spring.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEtudiantRepository extends CrudRepository<Etudiant,Long> {
}
