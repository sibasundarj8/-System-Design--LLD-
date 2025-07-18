package Tomato.models;

public class MenuItem {
    private Integer code;
    private String name;
    private Double price;

    // constructor
    public MenuItem(Integer code, String name, Double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    // getters
    public String getName() {
        return this.name;
    }

    public Double getPrice() {
        return this.price;
    }

    public Integer getCode() {
        return this.code;
    }

    // setters
    public void setPrice(Double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}