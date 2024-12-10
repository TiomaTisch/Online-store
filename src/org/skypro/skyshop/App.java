package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket();

        Product apple = new Product("Яблоко", 100);
        Product banana = new Product("Банан", 50);
        Product orange = new Product("Апельсин", 150);
        Product pear = new Product("Груша", 120);
        Product watermelon = new Product("Арбуз", 300);

        // Добавление продукта в корзину
        basket.addProduct(apple);
        basket.addProduct(banana);
        basket.addProduct(orange);
        basket.addProduct(pear);
        basket.addProduct(watermelon);

        // Добавление продукта в заполненную корзину
        basket.addProduct(new Product("Вишня", 200)); // Попытка добавить лишний продукт

        // Печать содержимого корзины
        basket.printContents();

        // Получение стоимости корзины
        System.out.println("Стоимость корзины: " + basket.getTotalCost());

        // Поиск товара, который есть в корзине
        System.out.println("Есть ли яблоко: " + basket.hasProduct("Яблоко"));

        // Поиск товара, которого нет в корзине
        System.out.println("Есть ли манго: " + basket.hasProduct("Манго"));

        // Очистка корзины
        basket.clearBasket();

        // Печать содержимого пустой корзины
        basket.printContents();

        // Получение стоимости пустой корзины
        System.out.println("Стоимость пустой корзины: " + basket.getTotalCost());

        // Поиск товара по имени в пустой корзине
        System.out.println("Есть ли яблоко: " + basket.hasProduct("Яблоко"));

    }
}