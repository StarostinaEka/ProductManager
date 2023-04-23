package ru.netology.productmanager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepoTest {

    @Test
    void testRemoveIdWhenIdExist() {
        ProductRepo repo = new ProductRepo();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Harry Potter 1", 100, "Rowling");
        Book book2 = new Book(2, "Harry Potter 2", 300, "Rowling");
        Book book3 = new Book(3, "War and Peace", 500, "Tolstoy");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);

        repo.removeById(1);

        Product[] actual = repo.findAll();
        Product[] expected = {book2,book3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testRemoveIdWhenIdNotExist() {
        ProductRepo repo = new ProductRepo();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Harry Potter 1", 100, "Rowling");
        Book book2 = new Book(2, "Harry Potter 2", 300, "Rowling");
        Book book3 = new Book(3, "War and Peace", 500, "Tolstoy");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);

        repo.removeById(4);

        Product[] actual = repo.findAll();
        Product[] expected = {book1,book2,book3};

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(4);
        });

        //Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    void add() {
    }

    @Test
    void removeById() {
    }

    @Test
    void findAll() {
    }
}