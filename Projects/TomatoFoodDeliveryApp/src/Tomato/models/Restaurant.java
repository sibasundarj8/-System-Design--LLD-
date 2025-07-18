package Tomato.models;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private final Integer id;
    private String name;
    private String address;
    private final List<MenuItem> items;
    private static int idCount = 0;

    // constructor
    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
        this.items = new ArrayList<>();
        this.id = idCount++;
    }

    // getters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // methods
    public void addMenuItem(MenuItem item) {
        this.items.add(item);
    }
}