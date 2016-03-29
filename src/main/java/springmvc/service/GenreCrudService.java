/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springmvc.service;

import org.springframework.data.repository.CrudRepository;
import springmvc.entity.Genre;

/**
 *
 * @author tom
 */
public interface GenreCrudService extends CrudRepository<Genre, Long>{
    
}
