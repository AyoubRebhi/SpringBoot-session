package com.example.spring.repository;

import com.example.spring.entity.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IFoyerRepository extends CrudRepository<Foyer,Long> {
}
