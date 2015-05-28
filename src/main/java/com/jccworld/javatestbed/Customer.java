package com.jccworld.javatestbed;

/**
 * User: jcc
 * Date: 24/05/15
 */
public class Customer {
    private final String title;
    private final String firstName;
    private final String lastName;

    public Customer(String title, String firstName, String lastName) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return title + " " + firstName + " " + lastName;
    }
}
