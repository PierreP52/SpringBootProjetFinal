package com.projetFinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.projetF.models.Artisan;
import com.projetF.repository.ArtisanRepository;

public class ArtisanService {
	
	@Autowired
    private ArtisanRepository artisanRepository;

    // Méthodes de service pour la logique métier associée à l'entité Artisan
    public List<Artisan> getAllArtisans() {
        return artisanRepository.findAll();
    }
}
