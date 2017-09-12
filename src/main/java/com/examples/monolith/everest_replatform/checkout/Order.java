package com.examples.monolith.everest_replatform.checkout;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author arungupta
 */
@Entity
@Table(name = "CART_ORDER")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    int orderId;
    
    @ElementCollection
    List<OrderItem> orderItems;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
