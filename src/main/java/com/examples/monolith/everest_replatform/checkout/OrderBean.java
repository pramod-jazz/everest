package com.examples.monolith.everest_replatform.checkout;



import com.examples.monolith.everest_replatform.cart.Cart;
import com.examples.monolith.everest_replatform.cart.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author arungupta
 */
@Repository
public class OrderBean implements Serializable {
    @Autowired
    Cart cart;
    
    String status;
    
    @PersistenceContext
    EntityManager em;
    
    @Transactional
    public void saveOrder() {
        Order order = new Order();
        List<OrderItem> items = new ArrayList<>();
        List<CartItem> cartItems = cart.getItems();
        for (CartItem cartItem : cartItems) {
            OrderItem orderItem = new OrderItem();
            orderItem.itemId = cartItem.getItemId();
            orderItem.itemCount = cartItem.getItemCount();
            items.add(orderItem);
        }
        order.setOrderItems(items);
        try {
            em.persist(order);
            status = "Order successful, order number: " + order.orderId;
            
            cart.clearCart();
        } catch (Exception e) {
            status = e.getLocalizedMessage();
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
