package com.examples.monolith.everest_replatform.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author arungupta
 */
@Repository
public class Cart implements Serializable {
    private List<CartItem> items;

    @Autowired
    CartItem currentCartItem;
    
    @PostConstruct
    private void init() {
        items = new ArrayList<>();
    }

    public List<CartItem> getItems() {
        return items;
    }
    
   /* public void addItemToCart(ActionEvent event) {
        boolean exists = false;
        
        int itemId = Integer.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("itemId"));
        String itemName = (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("itemName");
        
        for (CartItem item : items) {
            if (itemId == item.getItemId()) {
                exists = true;
                CartItem cartItem = new CartItem(item.getItemId(), itemName, item.getItemCount() + currentCartItem.getItemCount());
                items.remove(item);
                items.add(cartItem);
            }
        }
        if (!exists) {
            CartItem cartItem = new CartItem(itemId, itemName, currentCartItem.getItemCount());
            items.add(cartItem);
        }
    }*/
    
    public void clearCart() {
        items.clear();
    }
}
