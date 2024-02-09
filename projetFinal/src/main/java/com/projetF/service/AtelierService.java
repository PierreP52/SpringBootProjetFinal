package com.projetF.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetF.models.Atelier;
import com.projetF.repository.AtelierRepository;


@Service
public class AtelierService {
	@Autowired
    private AtelierRepository atelierRepository;

    // Méthodes de service pour la logique métier associée à l'entité Atelier
    public List<Atelier> getAllAteliers() {
        return atelierRepository.findAll();
    }
    public Atelier getAtelierById(Long id) {
        return atelierRepository.findById(id).orElse(null);
    }
}
