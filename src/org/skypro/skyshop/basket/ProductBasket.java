package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> products;

    public ProductBasket() {
        products = new HashMap<>();
    }

    public void addProduct(Product product) {
        String productName = product.getName();
        // Если продукты с таким именем уже есть, добавляем в список
        if (products.containsKey(productName)) {
            products.get(productName).add(product);
        } else {
            // Если нет, создаем новый список
            List<Product> productList = new ArrayList<>();
            productList.add(product);
            products.put(productName, productList);
        }
    }

    public double getTotalCost() {
        double totalCost = 0.0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                totalCost += product.getPrice();
            }
        }
        return totalCost;
    }

    public void printContents() {
        if (products == null) {
            System.out.println("в корзине пусто");
            return;
        }

        int specialProductCount = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                if (product != null) {
                    System.out.println(product);
                    if (product.isSpecial()) {
                        specialProductCount++;
                    }
                }
            }
        }
        System.out.println("Итого: " + getTotalCost());
        System.out.println("Специальных товаров: " + specialProductCount);
    }

    public boolean hasProduct(String productName) {
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                if (product != null && product.getName().equals(productName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean removeProductByName(String name) {
        return products.remove(name) != null;

    }

    public void clearBasket() {
        products.clear();
    }


}