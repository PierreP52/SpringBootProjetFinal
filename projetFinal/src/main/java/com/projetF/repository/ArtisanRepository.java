package com.projetF.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetF.models.Artisan;

@Repository
public interface ArtisanRepository extends JpaRepository<Artisan, Long> {
}