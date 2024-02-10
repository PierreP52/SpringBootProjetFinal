package com.projetF.projetFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetF.projetFinal.models.Artisan;

@Repository
public interface ArtisanRepository extends JpaRepository<Artisan, Long> {
}