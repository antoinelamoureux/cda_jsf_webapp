/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antoinelamoureux.cda_jsf_webapp.business;

import java.util.List;
import javax.ejb.EJBException;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author admin
 */
public abstract class AbstractFacade<T> {
    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    abstract public EntityManager getEntityManager();
    
    public List<T> findAll() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq = cq.select(cq.from(entityClass));
        
        return getEntityManager().createQuery(cq).getResultList();
    }
    
    public void create(T entityClass) {
        getEntityManager().persist(entityClass);
    }
    
    public T find(int id) {
        return getEntityManager().find(entityClass, id);
    }
    
    public void update(T entityClass) {
        getEntityManager().merge(entityClass);
    }
    
    public void destroy(T entityClass) throws EJBException {
        getEntityManager().remove(getEntityManager().merge(entityClass));
    }
    
}
