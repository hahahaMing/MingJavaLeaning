package com.mldn.shopping;

public class Book implements IGoods {
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Book)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Book book = (Book) obj;
        return this.name.equals(book.name) && this.price == book.price;
    }

    public String toString() {
        return "[Book Info] Name: " + this.name + ", Price: " + this.price;
    }
}
