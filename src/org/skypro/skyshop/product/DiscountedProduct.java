package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int basePrice;
    private final int discount;

    public DiscountedProduct(String name, int basePrice, int discount) {
        super(name);
        this.basePrice = basePrice;
        if (discount > 100) {
            this.discount = 0;
            System.out.println("Скидка не может быть больше 100% или отрицательной");
        }
        else {
            this.discount = discount;
        }
    }

    @Override
    public int getPrice() {
        return basePrice - (basePrice * discount / 100);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " (" + discount + "%)";
    }
}
