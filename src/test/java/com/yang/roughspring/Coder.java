package com.yang.roughspring;

/**
 *
 * @author yang
 * Date 2019/11/25 1:10
 */
public class Coder {
    private String name;
    private Book book;

    public Coder() {
    }

    public Coder(String name, Book book) {
        this.name = name;
        this.book = book;
    }

    public String getName() {
        return name;
    }

    public Book getBook() {
        return book;
    }
}
