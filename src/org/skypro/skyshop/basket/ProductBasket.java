package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] products = new Product[5];
    private int count = 0;

    public void addProduct(Product product) {
        if (count < products.length) {
            products[count++] = product;
        } else {
            System.out.println("Невозможно добавить продукт");
        }
    }

    public int getTotalCost() {
        int totalCost = 0;
        for (Product product : products) {
            if (product != null) {
                totalCost += product.getPrice();
            }
        }
        return totalCost;
    }

    public void printContents() {
        if (count == 0) {
            System.out.println("в корзине пусто");
            return;
        }

        int specialProductCount = 0;
        for (Product product : products) {
            if (product != null) {
                System.out.println(product);
                if (product.isSpecial()) {
                    specialProductCount++;
                }
            }
        }
        System.out.println("Итого: " + getTotalCost());
        System.out.println("Специальных товаров: " + specialProductCount);
    }

    public boolean hasProduct(String productName) {
        for (int i = 0; i < count; i++) {
            if (products[i] != null && products[i].getName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < count; i++) {
            products[i] = null;
        }
        count = 0;
        System.out.println("Корзина очищенна");
    }
}