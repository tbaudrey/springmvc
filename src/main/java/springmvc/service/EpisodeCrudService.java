/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springmvc.service;

import org.springframework.data.repository.CrudRepository;
import springmvc.entity.Episode;

/**
 *
 * @author tom
 */
public interface EpisodeCrudService extends CrudRepository<Episode, Long>{
    
}
