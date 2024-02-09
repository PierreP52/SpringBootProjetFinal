package com.projetF.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetF.models.Artisan;
import com.projetF.repository.ArtisanRepository;

@Service
public class ArtisanService {
	
	@Autowired
    private ArtisanRepository artisanRepository;

    // Méthodes de service pour la logique métier associée à l'entité Artisan
    public List<Artisan> getAllArtisans() {
        return artisanRepository.findAll();
    }
}
