package com.jccworld.javatestbed;

/**
 * User: jcc
 * Date: 24/05/15
 */
public class Customer {
    final String title;
    final String firstName;
    final String lastName;

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
