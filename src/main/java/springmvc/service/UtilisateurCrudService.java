/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springmvc.service;

import org.springframework.data.repository.CrudRepository;
import springmvc.entity.Utilisateur;

/**
 *
 * @author tom
 */
public interface UtilisateurCrudService extends CrudRepository<Utilisateur, Long>{
    
}
