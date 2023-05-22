package edu.school21.models;


import java.util.Objects;

public class Product {
    int id;
    String name;
    int price;
    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }

    @Override
    public String toString() {
        return "Product: {" +
                "id = " + id +
                ", name = " + name +
                ", price = " + price +
                "} ";
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        Product tmp = (Product) obj;
        return (tmp.id == this.id) && (Objects.equals(tmp.name, this.name)) && (tmp.price == this.price);
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }


}
