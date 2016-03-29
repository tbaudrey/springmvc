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
public class Serie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String titre_serie;
    private String synopsis;
     
    @OneToMany(mappedBy = "serie" )
    private List<Saison> saisons = new ArrayList<>();
     
    @ManyToOne
    @JoinColumn(name = "PAYS_ID")
    private Pays pays;

    public Long getId() {
        return id;
    }

    public Serie(){
    }

    public Serie(Long id, String titre_serie, String synopsis, Pays pays) {
        this.id = id;
        this.titre_serie = titre_serie;
        this.synopsis = synopsis;
        this.pays = pays;
    }
    
    public Serie(Long id, String titre_serie, String synopsis) {
        this.id = id;
        this.titre_serie = titre_serie;
        this.synopsis = synopsis;
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
        if (!(object instanceof Serie)) {
            return false;
        }
        Serie other = (Serie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "streaming.entity.Serie[ id=" + id + " + titre="+titre_serie+ " + synopsis="+ synopsis+" ]";
    }

    public String getTitre_serie() {
        return titre_serie;
    }

    public void setTitre_serie(String titre_serie) {
        this.titre_serie = titre_serie;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public List<Saison> getSaisons() {
        return saisons;
    }

    public void setSaisons(List<Saison> saisons) {
        this.saisons = saisons;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }


    public Serie(String titre_serie, String synopsis) {
        this.titre_serie = titre_serie;
        this.synopsis = synopsis;
    }
    
    
    
    
}
