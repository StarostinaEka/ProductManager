package ru.netology.productmanager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    @Test
    void testAdd() {
        ProductRepo repo = new ProductRepo();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Harry Potter 1", 100, "Rowling");
        Book book2 = new Book(2, "Harry Potter 2", 300, "Rowling");
        Book book3 = new Book(3, "War and Peace", 500, "Tolstoy");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    void testSearchByWhenFewProductsFind() {
        ProductRepo repo = new ProductRepo();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Harry Potter 1", 100, "Rowling");
        Book book2 = new Book(2, "Harry Potter 2", 300, "Rowling");
        Book book3 = new Book(3, "War and Peace", 500, "Tolstoy");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Potter");
        Product[] expected = {book1, book2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testSearchByWhenNoProductsFind() {
        ProductRepo repo = new ProductRepo();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Harry Potter 1", 100, "Rowling");
        Book book2 = new Book(2, "Harry Potter 2", 300, "Rowling");
        Book book3 = new Book(3, "War and Peace", 500, "Tolstoy");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Hamlet");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    void testSearchByWhenOneProductsFind() {
        ProductRepo repo = new ProductRepo();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Harry Potter 1", 100, "Rowling");
        Book book2 = new Book(2, "Harry Potter 2", 300, "Rowling");
        Book book3 = new Book(3, "War and Peace", 500, "Tolstoy");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Peace");
        Product[] expected = {book3};

        Assertions.assertArrayEquals(expected, actual);
    }
}