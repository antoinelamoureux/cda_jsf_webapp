/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antoinelamoureux.cda_jsf_webapp.business;

import com.antoinelamoureux.cda_jsf_webapp.entities.Theme;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ThemeFacade extends AbstractFacade<Theme> {
    @PersistenceContext(unitName="my_persistence_unit")
    EntityManager em;
    
    public ThemeFacade() {
        super(Theme.class);
    }

    @Override
    public EntityManager getEntityManager() {
     return em;   
    }
    
    
}
