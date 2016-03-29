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
import springmvc.entity.Effacemoi;
import springmvc.service.EffacemoiCrudService;

/**
 *
 * @author tom
 */
@Controller
@RequestMapping(value = "/effacemoi")
public class EffacemoiController {
    
    @Autowired
    private EffacemoiCrudService effacemoiCrudService; 
    
    @RequestMapping(value = "ajouterPOST", method = RequestMethod.POST)
    public String ajouterPOST(@ModelAttribute(value = "monEffaceMoi") Effacemoi em){
        
        effacemoiCrudService.save(em);
        return "redirect:/effacemoi/lister";
    }
    
    @RequestMapping(value = "ajouter", method = RequestMethod.GET)
    public String ajouter(Model model){
        
        model.addAttribute("monEffaceMoi", new Effacemoi() );
                
        System.out.println("ajouter");
        return "effacemoi_ajouter";

//    return this.effaceMoi();   
//équivalent à : 
//        return "forward:/effacemoi/lister";
//        return "redirect:/effacemoi/lister";
    }
    
    @RequestMapping(value = "lister", method = RequestMethod.GET)
    public String effaceMoi(Model model){
        
        Iterable<Effacemoi> liste = effacemoiCrudService.findAll();
        
        model.addAttribute("maListe", liste);
        
        System.out.println("lister");
        return "lister";
    }
    
    @RequestMapping(value = "detail/{idDuRecord}", method = RequestMethod.GET)
    public String detail(@PathVariable(value = "idDuRecord") long monId){
        
        System.out.println(monId);
        return null;
    }
    
    
    
    
}
