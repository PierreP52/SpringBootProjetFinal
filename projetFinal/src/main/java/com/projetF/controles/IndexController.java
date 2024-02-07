package com.projetF.controles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String showIndexPage() {
        return "index"; // Ceci renvoie le nom de la vue (index.html dans ce cas)
    }
}

