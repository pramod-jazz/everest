package com.examples.monolith.everest_replatform.catalog;

import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

/**
 * @author arungupta
 */
@Repository
public class CatalogItemBean implements Serializable {
    @PersistenceContext
    EntityManager em;
    
    public List<CatalogItem> getItems() {
        return em.createNamedQuery("CatalogItem.findAll", CatalogItem.class).getResultList();
    }
    

    public CatalogItem getItemWithId(int itemId) {
        return em.createNamedQuery("CatalogItem.findById", CatalogItem.class).setParameter("id", itemId).getSingleResult();
    }
}
