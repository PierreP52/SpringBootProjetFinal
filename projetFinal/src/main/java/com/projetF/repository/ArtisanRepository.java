package com.projetF.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetF.models.Artisan;

public interface ArtisanRepository extends JpaRepository<Artisan, Long> {
}