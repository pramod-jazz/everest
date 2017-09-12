package com.examples.monolith.everest_replatform.checkout;

import org.springframework.stereotype.Component;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author arungupta
 */
@Component
public class OrderItem implements Serializable {
    int itemId;
    int itemCount;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }
    
}
