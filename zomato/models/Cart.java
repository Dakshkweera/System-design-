package models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    // 1. Encapsulated Variables
    private Restaurant currentRestaurant;
    private List<MenuItem> items;

    // 2. The Constructor
    public Cart() {
        this.currentRestaurant = null; // Empty cart has no restaurant yet
        this.items = new ArrayList<>(); // Diamond operator!
    }

    // 3. The Behavior: Adding an item with a strict rule
    public boolean addItem(MenuItem item, Restaurant restaurant) {
        // If cart is empty, lock it to this restaurant
        if (this.currentRestaurant == null) {
            this.currentRestaurant = restaurant;
        }

        // Security Check: Is the user trying to order from two places at once?
        if (!this.currentRestaurant.getId().equals(restaurant.getId())) {
            System.out.println("Error: Cannot add items from different restaurants. Clear cart first.");
            return false; 
        }

        this.items.add(item);
        return true;
    }

    // 4. Calculating total on the fly (Safe from state mismatch)
    public double calculateTotal() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice(); // Notice we use the getter!
        }
        return total;
    }

    // 5. Cart Management
    public void clear() {
        this.items.clear();
        this.currentRestaurant = null; // Release the restaurant lock
    }

    public boolean isEmpty() {
        return this.items.isEmpty();
    }
    
    public List<MenuItem> getItems() {
        return this.items;
    }
}