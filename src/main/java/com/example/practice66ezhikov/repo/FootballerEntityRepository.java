package com.example.practice66ezhikov.repo;

import com.example.practice66ezhikov.entity.FootballerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface FootballerEntityRepository extends JpaRepository<FootballerEntity, Integer> {
    @Query("select distinct f.teamName from FootballerEntity f")
    List<String> findAllTeams();
}

