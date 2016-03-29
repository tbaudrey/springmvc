/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springmvc.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *Entité gérant les pays.
 * passe par la
 * @author admin
 */

@Entity
public class Pays implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToMany(mappedBy = "pays")
    private List<Serie> mes_series = new ArrayList<>();
    
    @OneToMany(mappedBy = "pays")
    private List<Film> mes_films = new ArrayList<>();
    
    private String nom;

    public Pays() {
    }

    public Pays(Long id, String nom) {
        this.id = id;
        this.nom = nom;
    }
    
    
    
    public void setNom(String nom){
        this.nom = nom;
    }
    
    public String getNom(){
        return nom;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Serie> getMes_series() {
        return mes_series;
    }

    public void setMes_series(List<Serie> mes_series) {
        this.mes_series = mes_series;
    }

    public List<Film> getMes_films() {
        return mes_films;
    }

    public void setMes_films(List<Film> mes_films) {
        this.mes_films = mes_films;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pays)) {
            return false;
        }
        Pays other = (Pays) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNom();
    }
    
}
