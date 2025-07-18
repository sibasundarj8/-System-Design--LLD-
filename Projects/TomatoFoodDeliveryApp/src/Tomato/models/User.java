package Tomato.models;

public class User {
    private final Integer id;
    private String name;
    private String address;
    private final Cart cart = new Cart();

    // constructor
    public User(int userId, String name, String address) {
        this.id = userId;
        this.name = name;
        this.address = address;
    }

    // getters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Cart getCart() {
        return cart;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}