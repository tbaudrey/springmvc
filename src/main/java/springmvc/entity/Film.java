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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Entité gérant les films
 * Je suis passé par la ! Arthur
 * @author admin
 */
@Entity
public class Film implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToMany(mappedBy = "quel_film")
    private List<Lien> liens = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name = "ID_GENRE")
    private Genre genre;
     
    @ManyToOne
    @JoinColumn(name = "ID_PAYS")
    private Pays pays;
    
    @ManyToMany
    @JoinTable(name = "film_realisateur")
    private List<Realisateur> createurs = new ArrayList<>();
    
    private String titre;
    private String sinopsis;
    private Long anneeProd;

    public Film() {
    }

    public Film(Genre genre, Pays pays, String titre, String sinopsis, Long anneeProd) {
        this.genre = genre;
        this.pays = pays;
        this.titre = titre;
        this.sinopsis = sinopsis;
        this.anneeProd = anneeProd;
    }
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Lien> getLiens() {
        return liens;
    }

    public void setLiens(List<Lien> liens) {
        this.liens = liens;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public List<Realisateur> getCreateurs() {
        return createurs;
    }

    public void setCreateurs(List<Realisateur> createurs) {
        this.createurs = createurs;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public Long getAnneeProd() {
        return anneeProd;
    }

    public void setAnneeProd(Long anneeProd) {
        this.anneeProd = anneeProd;
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
        if (!(object instanceof Film)) {
            return false;
        }
        Film other = (Film) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "streaming.entity.Film[ id=" + id +" nom="+titre+" ]";
    }
    
}
