package com.examples.monolith.everest_replatform.uzer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;

/**
 * @author arungupta
 */
@Repository
public class UzerBean implements Serializable {
    @PersistenceContext
    EntityManager em;


    
    String status;
    
    @Transactional
    public void addUzer(UzerItem uzerItem ) {
        Uzer uzer = new Uzer();
        uzer.setLogin(uzerItem.getLogin());
        uzer.setPassword(uzerItem.getPassword());
        uzer.setUsername(uzerItem.getUsername());
        uzer.setAddress1(uzerItem.getAddress1());
        uzer.setAddress2(uzerItem.getAddress2());
        uzer.setCity(uzerItem.getCity());
        uzer.setState(uzerItem.getState());
        uzer.setCountry(uzerItem.getCountry());
        uzer.setZip(uzerItem.getZip());
        uzer.setCreditcard(uzerItem.getCreditcard());
        
        try {
            em.persist(uzer);
        } catch (Exception e) {
            status = e.getLocalizedMessage();
            return;
        }
        
        status = "User added successfully, login: \"" + uzer.getLogin() + "\", password: \"" + uzer.getPassword() + "\"";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
