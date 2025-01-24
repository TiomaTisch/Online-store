package org.skypro.skyshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

public class App {
    public static void main(String[] args) {

        SearchEngine searchEngine = new SearchEngine();
        ProductBasket basket = new ProductBasket();

        // Добавление товаров
        Product apple = new SimpleProduct("Яблоко", 100);
        searchEngine.addItem(apple);
        Product  banana = new SimpleProduct("Банан", 50);
        searchEngine.addItem(banana);
        Product  orange = new DiscountedProduct("Апельсин", 150, 20);
        searchEngine.addItem(orange);
        Product  orange1 = new DiscountedProduct("Апельсин", 150, 100);
        searchEngine.addItem(orange1);
        Product  pear = new FixPriceProduct("Груша");
        searchEngine.addItem(pear);
        Product  watermelon = new DiscountedProduct("Арбуз", 300, 42);
        searchEngine.addItem(watermelon);

        // Добавление статей
        Article article1 = new Article("Польза яблок", "Яблоки полезны для здоровья.");
        searchEngine.addItem(article1);
        Article article2 = new Article("Польза Бананов", "Бананы полезны для здоровья.");
        searchEngine.addItem(article2);
        Article article3 = new Article("Польза Апельсинов", "Апельсины полезны для здоровья.");
        searchEngine.addItem(article3);
        Article article4 = new Article("Польза Грушы", "Грушы полезны для здоровья.");
        searchEngine.addItem(article4);
        Article article5 = new Article("Польза Арбуза", "Арбуз полезен для здоровья.");
        searchEngine.addItem(article5);
        Article article6 = new Article("Польза Вишни", "Вишня полезна для здоровья.");
        searchEngine.addItem(article6);

        // Добавление продукта в корзину
        basket.addProduct(apple);
        basket.addProduct(banana);
        basket.addProduct(orange);
        basket.addProduct(pear);
        basket.addProduct(watermelon);


        // Печать содержимого корзины
        basket.printContents();

        // Получение стоимости корзины
        System.out.println("Стоимость корзины: " + basket.getTotalCost());

        // Поиск товара, который есть в корзине
        System.out.println("Есть ли яблоко: " + basket.hasProduct("Яблоко"));

        // Поиск товара, которого нет в корзине
        System.out.println("Есть ли манго: " + basket.hasProduct("Манго"));

        // Уделение из корзины
        basket.removeProductByName("Яблоко");

        // Очистка корзины
        basket.clearBasket();

        // Печать содержимого пустой корзины
        basket.printContents();

        // Получение стоимости пустой корзины
        System.out.println("Стоимость пустой корзины: " + basket.getTotalCost());

        // Поиск товара по имени в пустой корзине
        System.out.println("Есть ли яблоко: " + basket.hasProduct("Яблоко"));

        // Поиск по термину
        String query = "Груш";
        System.out.println("Результаты поиска для \"" +  query + " " + searchEngine.search(query) + "\":");
        query = "Огурец";
        System.out.println("Результаты поиска для \"" +  query + " " + searchEngine.search(query) + "\":");

        try {
            SimpleProduct product = new SimpleProduct("  ", 10);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            DiscountedProduct product = new DiscountedProduct("Product", 100, 120);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            List<Searchable> bestMatch = searchEngine.findBestMatch("Груш");
            System.out.println("Найден лучший результат: " + bestMatch);

        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

    }
}