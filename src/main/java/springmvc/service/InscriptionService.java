/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springmvc.service;

import java.util.List;
import springmvc.entity.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class InscriptionService {

    @Autowired
    private UtilisateurCrudService utilisateurCrudService;

    public Boolean inscription(Utilisateur j) {

        List<Utilisateur> listeUtilisateurs = (List<Utilisateur>) utilisateurCrudService.findAll();
        if (!listeUtilisateurs.isEmpty()){
            for (Utilisateur j2 : listeUtilisateurs) {
                if (j.getLogin().equals(j2.getLogin())) {
                    return false;
                }
            }
        }
        utilisateurCrudService.save(j);
        return true;
    }

}
