package com.projetF.projetFinal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetF.projetFinal.models.Artisan;
import com.projetF.projetFinal.repository.ArtisanRepository;

@Service
public class ArtisanService {
	
	 private ArtisanRepository artisanRepository;

	    @Autowired
	    public ArtisanService(ArtisanRepository artisanRepository) {
	        this.artisanRepository = artisanRepository;
	    }

	    // Méthode pour récupérer tous les artisans
	    public List<Artisan> getAllArtisans() {
	        return artisanRepository.findAll();
	    }

	    // Méthode pour récupérer un artisan par son ID
	    public Optional<Artisan> getArtisanById(Long artisanId) {
	        return artisanRepository.findById(artisanId);
	    }
}
