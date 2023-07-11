package com.DEAiFISH.di;

public class Book {
    private String name;
    private String author;
    private String others;

    public Book() {
        System.out.println("无参构造执行...");
    }

    public Book(String name, String author) {
        this.name = name;
        this.author = author;

        System.out.println("有参构造执行...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", others='" + others + '\'' +
                '}';
    }
}
