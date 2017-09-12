package com.examples.monolith.everest_replatform.checkout;


import com.examples.monolith.everest_replatform.uzer.Uzer;
import com.examples.monolith.everest_replatform.uzer.UzerItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

/**
 * @author arungupta
 */
@Repository
public class Shipping implements Serializable {
    
   @PersistenceContext
    EntityManager em;
    
    @Autowired
    UzerItem uzer2;
//    String login;
//    
//    String name;
//    String address1;
//    String address2;
//    String city;
//    String zip;
//    String country;
//    String creditcard;
    
    public Shipping() { }
    
    public void findShippingDetail() {
        System.out.println("LOGIN: " + uzer2.getLogin());
        Uzer uzer = em.createNamedQuery("Uzer.findByLogin", Uzer.class).setParameter("login", uzer2.getLogin()).getSingleResult();
        uzer.setUsername(uzer2.getUsername());
        uzer.setAddress1(uzer2.getAddress1());
        uzer.setAddress2(uzer2.getAddress2());
        uzer.setCity(uzer2.getCity());
        uzer.setZip(uzer2.getZip());
        uzer.setCountry(uzer2.getCountry());
        uzer.setCreditcard(uzer2.getCreditcard());
    }
}
