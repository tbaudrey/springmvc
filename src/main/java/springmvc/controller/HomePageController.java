/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author tom
 */
@Controller
public class HomePageController {
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String effaceMoi(){
        
        System.out.println("Passe par la");
        
        return "homePage";
    }
}
