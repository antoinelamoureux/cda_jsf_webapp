/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antoinelamoureux.cda_jsf_webapp.business;

import com.antoinelamoureux.cda_jsf_webapp.entities.Tag;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TagFacade extends AbstractFacade<Tag>{
    @PersistenceContext(unitName="my_persistence_unit")
    EntityManager em;

    public TagFacade() {
        super(Tag.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
    
}
