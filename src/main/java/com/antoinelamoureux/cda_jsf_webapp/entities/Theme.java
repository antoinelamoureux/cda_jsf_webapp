/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antoinelamoureux.cda_jsf_webapp.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "themes")
@NamedQueries({
    @NamedQuery(name = "Theme.findAll", query = "SELECT t FROM Theme t"),
    @NamedQuery(name = "Theme.findByIdTheme", query = "SELECT t FROM Theme t WHERE t.idTheme = :idTheme"),
    @NamedQuery(name = "Theme.findByLibelle", query = "SELECT t FROM Theme t WHERE t.libelle = :libelle")})
public class Theme implements Serializable {

    @Size(max = 60)
    @Column(name = "libelle")
    private String libelle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theme")
    private Collection<News> newsCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_theme")
    private Integer idTheme;

    public Theme() {
    }

    public Theme(Integer idTheme) {
        this.idTheme = idTheme;
    }

    public Integer getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(Integer idTheme) {
        this.idTheme = idTheme;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTheme != null ? idTheme.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Theme)) {
            return false;
        }
        Theme other = (Theme) object;
        if ((this.idTheme == null && other.idTheme != null) || (this.idTheme != null && !this.idTheme.equals(other.idTheme))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.antoinelamoureux.cda_jsf_webapp.entities.Themes[ idTheme=" + idTheme + " ]";
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Collection<News> getNewsCollection() {
        return newsCollection;
    }

    public void setNewsCollection(Collection<News> newsCollection) {
        this.newsCollection = newsCollection;
    }
    
}
