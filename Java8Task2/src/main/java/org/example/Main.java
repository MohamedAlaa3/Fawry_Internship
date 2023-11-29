package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
class StreamsExample {

    public static void main(final String[] args) {

        List<Author> authors = Library.getAuthors();

        banner("Authors information");
        // TODO With functional interfaces declared
        Consumer<Author> printer = System.out::println;
        authors
                .stream()
                .forEach(printer);

        // TODO With functional interfaces used directly
        authors
                .stream()
                .forEach(System.out::println);

        banner("Active authors");
        // TODO With functional interfaces declared
        Consumer<Author> activeAuthorsPrinter = author -> {
            if (author.active) {
                System.out.println(author);
            }
        };
        authors
                .stream()
                .forEach(activeAuthorsPrinter);


        // TODO With functional interfaces used directly
        banner("directly");
        authors
                .stream()
                .filter(author -> author.active)
                .forEach(System.out::println);


        banner("Active books for all authors");
        // TODO With functional interfaces declared
        Consumer<Author> activeBooksPrinter = author -> {
            System.out.println(author.name);
            author.books
                    .stream()
                    .filter(book -> book.published)
                    .forEach(System.out::println);
            System.out.println();
        };
        authors
                .stream()
                .forEach(activeBooksPrinter);

        // TODO With functional interfaces used directly
        banner("directly");
        authors
                .stream()
                .forEach(author -> {
                    System.out.println(author.name);
                    author.books
                            .stream()
                            .filter(book -> book.published)
                            .forEach(System.out::println);
                    System.out.println();
                });

        banner("Average price for all books in the library");
        // TODO With functional interfaces declared
        banner("Average price for all books in the library");
        Consumer<Author> averagePriceCalculator = author -> {
            double averagePrice = author.books
                    .stream()
                    .mapToDouble(book -> book.price)
                    .average()
                    .orElse(0);
            System.out.println(author.name + "\t| Average Price: $" + averagePrice);
        };
        authors
                .stream()
                .forEach(averagePriceCalculator);


        // TODO With functional interfaces used directly
        banner("directly");
        authors
                .stream()
                .forEach(author -> {
                    double averagePrice = author.books
                            .stream()
                            .mapToDouble(book -> book.price)
                            .average()
                            .orElse(0);
                    System.out.println(author.name + "\t| Average Price: $" + averagePrice);
                });

        banner("Active authors that have at least one published book");
        // TODO With functional interfaces declared
        Consumer<Author> activeAuthorsWithPublishedBookPrinter = author -> {
            boolean hasPublishedBook = author.books
                    .stream()
                    .anyMatch(book -> book.published);
            if (author.active && hasPublishedBook) {
                System.out.println(author);
            }
        };
        authors
                .stream()
                .forEach(activeAuthorsWithPublishedBookPrinter);

        // TODO With functional interfaces used directly
        banner("directly");
        authors
                .stream()
                .filter(author -> author.active && author.books.stream().anyMatch(book -> book.published))
                .forEach(System.out::println);


    }

    private static void banner(final String m) {
        System.out.println("#### " + m + " ####");
    }
}


class Library {
    public static List<Author> getAuthors() {
        return Arrays.asList(
                new Author("Author A", true, Arrays.asList(
                        new Book("A1", 100, true),
                        new Book("A2", 200, true),
                        new Book("A3", 220, true))),
                new Author("Author B", true, Arrays.asList(
                        new Book("B1", 80, true),
                        new Book("B2", 80, false),
                        new Book("B3", 190, true),
                        new Book("B4", 210, true))),
                new Author("Author C", true, Arrays.asList(
                        new Book("C1", 110, true),
                        new Book("C2", 120, false),
                        new Book("C3", 130, true))),
                new Author("Author D", false, Arrays.asList(
                        new Book("D1", 200, true),
                        new Book("D2", 300, false))),
                new Author("Author X", true, Collections.emptyList()));
    }
}

class Author {
    String name;
    boolean active;
    List<Book> books;

    Author(String name, boolean active, List<Book> books) {
        this.name = name;
        this.active = active;
        this.books = books;
    }

    @Override
    public String toString() {
        return name + "\t| " + (active ? "Active" : "Inactive");
    }
}

class Book {
    String name;
    int price;
    boolean published;

    Book(String name, int price, boolean published) {
        this.name = name;
        this.price = price;
        this.published = published;
    }

    @Override
    public String toString() {
        return name + "\t| " + "\t| $" + price + "\t| " + (published ? "Published" : "Unpublished");
    }
}
