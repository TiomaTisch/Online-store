package org.skypro.skyshop.product;

public class SimpleProduct extends Product {

    private final int regularPrice;

    public SimpleProduct(String name, int regularPrice) {
        super(name); // Вызов конструктора родительского класса
        this.regularPrice = regularPrice; // Установка обычной цены
    }

    @Override
    public int getPrice() {
        return regularPrice;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice();
    }


}
