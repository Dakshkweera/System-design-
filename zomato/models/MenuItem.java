package models;

public class MenuItem {
    private String id;  // private so that can't be accessed directly
    private String name;
    private Double price;

    public MenuItem(String id, String name, Double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public Double getPrice(){
        return price;
    }
}
