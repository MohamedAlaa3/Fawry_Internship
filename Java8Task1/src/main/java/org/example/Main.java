package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

class LambdaExample {

    public static void main(final String[] args) {

        final UsersRepository repository = new UsersRepository();

        banner("Listing all users");
        repository.select(null, null);

        banner("Listing users with age > 5 sorted by name");
        // TODO once using anonymous objects and once using lambda expressions
        repository.select(new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.age > 5;
            }
        }, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.name.compareTo(o2.name);
            }
        });

        banner("lambda expressions");
        repository.select(user -> user.age > 5, (user1, user2) -> user1.name.compareTo(user2.name));


        banner("Listing users with age < 10 sorted by age");
        // TODO once using anonymous objects and once using lambda expressions
        repository.select(new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.age < 10;
            }
        }, new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                return Integer.compare(user1.age, user2.age);
            }
        });

        banner("lambda expressions");
        repository.select(user -> user.age < 10, (user1, user2) -> Integer.compare(user1.age, user2.age));

        banner("Listing active users sorted by name");
        // TODO once using anonymous objects and once using lambda expressions
        repository.select(new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.active;
            }
        }, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.name.compareTo(o2.name);
            }
        });

        banner("lambda expressions");
        repository.select(user -> user.active, (user1, user2) -> user1.name.compareTo(user2.name));

        banner("Listing active users with age > 8 sorted by name");
        // TODO once using anonymous objects and once using lambda expressions
        repository.select(new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.age > 8;
            }
        }, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.name.compareTo(o2.name);
            }
        });

        banner("lambda expressions");
        repository.select(user -> user.age > 8, Comparator.comparing(user -> user.name));


    }

    private static void banner(final String m) {
        System.out.println("#### " + m + " ####");
    }

}

class UsersRepository {
    List<User> users;

    UsersRepository() {
        users = Arrays.asList(new User("Seven", 7, true), new User("Four", 4, false), new User("Eleven", 11, true), new User("Three", 3, true), new User("Nine", 9, false), new User("One", 1, true), new User("Twelve", 12, true));
    }

    void select(final Predicate<User> filter, final Comparator<User> order) {
        Stream<User> usersStream = users.stream();

        if (filter != null) {
            usersStream = usersStream.filter(filter);
        }
        if (order != null) {
            usersStream = usersStream.sorted(order);
        }
        usersStream.forEach(System.out::println);
    }
}

class User {
    String name;
    int age;
    boolean active;

    User(final String name, final int age, boolean active) {
        this.name = name;
        this.age = age;
        this.active = active;
    }

    @Override
    public String toString() {
        return name + "\t| " + age;
    }
}