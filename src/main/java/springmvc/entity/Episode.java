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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author admin
 */
@Entity
public class Episode implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    private Long num_Episode;
    private String titre_Episode;
    
    @ManyToOne
    @JoinColumn(name = "ID_SAISON")
    private Saison saison;
    
    @OneToMany(mappedBy = "quel_episode")
    private List<Lien> episodeLien = new ArrayList<Lien>();
    
    public Episode(){
    }

    public Long getNum_Episode() {
        return num_Episode;
    }

    public void setNum_Episode(Long num_Episode) {
        this.num_Episode = num_Episode;
    }

    public String getTitre_Episode() {
        return titre_Episode;
    }

    public void setTitre_Episode(String titre_Episode) {
        this.titre_Episode = titre_Episode;
    }

    public Saison getSaison() {
        return saison;
    }

    public void setSaison(Saison saison) {
        this.saison = saison;
    }

    public List<Lien> getEpisodeLien() {
        return episodeLien;
    }

    public void setEpisodeLien(List<Lien> episodeLien) {
        this.episodeLien = episodeLien;
    }

    public Episode(Long id, Long num_Episode, String titre_Episode, Saison saison) {
        this.id = id;
        this.num_Episode = num_Episode;
        this.titre_Episode = titre_Episode;
        this.saison = saison;
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
        if (!(object instanceof Episode)) {
            return false;
        }
        Episode other = (Episode) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "streaming.entity.Episode[ id=" + id + " ]";
    }
    
}
