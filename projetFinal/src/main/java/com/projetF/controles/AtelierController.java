package com.projetF.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetF.models.Atelier;
import com.projetF.service.AtelierService;


@RestController
@RequestMapping("/ateliers")
public class AtelierController {

    @Autowired
    private AtelierService atelierService;

    @GetMapping
    public String getAllAteliers(Model model) {
        // Récupérer la liste de tous les ateliers
        List<Atelier> ateliers = atelierService.getAllAteliers();
        
        // Ajouter la liste d'ateliers au modèle pour l'affichage dans la vue
        model.addAttribute("ateliers", ateliers);
        
        // Retourner le nom de la vue correspondante
        return "ateliersList";
    }
}
