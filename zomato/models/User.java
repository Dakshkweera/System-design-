package models;

public class User {
    // 1. Encapsulated State
    private String id;
    private String name;
    private String location;
    
    // Composition: A User OWNS a Cart
    private Cart cart;

    // 2. The Constructor (Sign-up process)
    public User(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
        
        // THE LIFESAVER: The moment a user signs up, give them an empty cart!
        // If you force the Main class to create the cart, they will forget, 
        // and your app will throw a NullPointerException when the user clicks "Add Item".
        this.cart = new Cart(); 
    }

    // 3. Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getLocation() { return location; }
    public Cart getCart() { return cart; }
}
