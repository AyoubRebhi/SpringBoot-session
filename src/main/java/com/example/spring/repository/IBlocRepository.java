package com.example.spring.repository;

import com.example.spring.entity.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IBlocRepository extends CrudRepository<Bloc,Long> {}

