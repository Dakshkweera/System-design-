package models;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String id;
    private String name;
    private String location;

    private List<MenuItem> menu;

    public Restaurant(String id,String name,String location){
        this.name = name;
        this.id = id;
        this.location=location;

        this.menu = new ArrayList<>();
    }

    public void addItem(MenuItem item){
        if(item!=null){
            this.menu.add(item);
        }
    }

    public String getLocation(){
        return location;
    }
    public String getName(){
        return name;
    }
    public String getId(){
        return id;
    }
    public List<MenuItem> getList(){
        return menu;
    }
}
