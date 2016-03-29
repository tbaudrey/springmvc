/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springmvc.entity.Film;
import springmvc.entity.Genre;
import springmvc.service.GenreCrudService;

/**
 *
 * @author admin
 */
@Controller
@RequestMapping(value = "/genre")
public class GenreController {

    @Autowired
    GenreCrudService genreCrudService;

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
        System.out.print(id);
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
