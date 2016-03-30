/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springmvc.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springmvc.entity.Genre;
import springmvc.entity.Utilisateur;
import springmvc.service.GenreCrudService;
import springmvc.service.InscriptionService;
import springmvc.service.UtilisateurCrudService;

/**
 *
 * @author admin
 */
@Controller
@RequestMapping(value = "/genre")
public class GenreController {

    @Autowired
    GenreCrudService genreCrudService;
    
    @Autowired
    UtilisateurCrudService utilisateurCrudService;
    
    @Autowired
    InscriptionService inscriptionService;
    
    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String home() {
        return "indexInit";
    }
    
    @RequestMapping(value = "non_logger", method = RequestMethod.GET)
    public String non_logger(Model m) {
        m.addAttribute("monUtilisateur", new Utilisateur());
        return "_non_logger";
    }
    
    @RequestMapping(value = "inscription", method = RequestMethod.GET)
    public String inscription(Model m) {
        m.addAttribute("monUtilisateur", new Utilisateur());
        return "inscription";
    }
    
    @RequestMapping(value = "inscriptionPOST", method = RequestMethod.POST)
    public String inscriptionPOST(@ModelAttribute(value = "monUtilisateur") Utilisateur utilisateur) {
        
        Boolean etatInscription = inscriptionService.inscription(utilisateur);

//        if (etatInscription == false) {
//            return "inscription";
//        } else {
            return "indexInit";
//        }
    }
    
    @RequestMapping(value = "loginPOST", method = RequestMethod.POST)
    public String loginPOST(@ModelAttribute(value = "monUtilisateur") Utilisateur utilisateur, Model model) {
        
        List<Utilisateur> listeUtilisateurs = new ArrayList<>();
        listeUtilisateurs = (List<Utilisateur>) utilisateurCrudService.findAll();
        
        Boolean estLogger = false;
        if (!listeUtilisateurs.isEmpty()) {
            for (Utilisateur j : listeUtilisateurs) {
                if (j.getLogin().equals(utilisateur.getLogin())) {
                    if (j.getMdp().equals(utilisateur.getMdp())) {
                        estLogger = true;
                    }
                }
            }
        }
        model.addAttribute("monLogin", utilisateur.getLogin());
        System.out.println("11111111111111111111111111111111111111111111"+utilisateur.getLogin());

        return "index";
    }
    
    @RequestMapping(value = "logger", method = RequestMethod.GET)
    public String logger(@ModelAttribute(value = "monUtilisateur") Utilisateur utilisateur, Model model) {
        System.out.println("222222222222222222222222222222222222222222222"+utilisateur.getLogin());
        model.addAttribute("monLogin", utilisateur.getLogin());
        return "_logger";
    }    


    @RequestMapping(value = "lister", method = RequestMethod.GET)
    public String lister(Model model) {

        Iterable<Genre> listeGenre = genreCrudService.findAll();

        model.addAttribute("maListe", listeGenre);

        return "genre_lister";
    }
    
    @RequestMapping(value = "genre_ajouter", method = RequestMethod.GET)
    public String ajouter(Model model) {

        model.addAttribute("monGenre", new Genre());

        return "genre_ajouter";
    }

    @RequestMapping(value = "ajouterPOST", method = RequestMethod.POST)
    public String ajouter(@ModelAttribute(value = "monGenre") Genre g) {
        genreCrudService.save(g);
        return "redirect:/genre/lister";
    }

    @RequestMapping(value = "genre_modifier/{idGenre}", method = RequestMethod.GET)
    public String modifier(@PathVariable(value = "idGenre") long id, Model model) {
        Genre g = genreCrudService.findOne(id);
        model.addAttribute("monGenre", g);

        return "genre_modifier";
    }

    @RequestMapping(value = "genre_modifier/{idGenre}", method = RequestMethod.POST)
    public String modifierPOST(@ModelAttribute(value = "monGenre") Genre g) {
        
        genreCrudService.save(g);

        return "redirect:/genre/lister";
    }

    @RequestMapping(value = "genre_supprimer/{idGenre}", method = RequestMethod.GET)
    public String supprimer(@PathVariable(value = "idGenre") long id) {
        Genre g = genreCrudService.findOne(id);
        genreCrudService.delete(g);

        return "redirect:/genre/lister";
    }
}
