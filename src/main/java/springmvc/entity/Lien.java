/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springmvc.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author admin
 */
@Entity
public class Lien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String wrl;
    
    @ManyToOne
    @JoinColumn(name = "ID_EPISODE")
    private Episode quel_episode;
    
    @ManyToOne
    @JoinColumn(name = "ID_FILM")
    private Film quel_film;
    
    public Lien(){
    }

    public Lien(Long id, String wrl, Episode quel_episode) {
        this.id = id;
        this.wrl = wrl;
        this.quel_episode = quel_episode;
    }

    public String getWrl() {
        return wrl;
    }

    public void setWrl(String wrl) {
        this.wrl = wrl;
    }

    public Episode getQuel_episode() {
        return quel_episode;
    }

    public void setQuel_episode(Episode quel_episode) {
        this.quel_episode = quel_episode;
    }

    public Film getQuel_film() {
        return quel_film;
    }

    public void setQuel_film(Film quel_film) {
        this.quel_film = quel_film;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Lien)) {
            return false;
        }
        Lien other = (Lien) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getWrl();
    }
    
}
