package com.jccworld.javatestbed;

/**
 * Created by john.crossley on 27/05/2015.
 */
public class Transaction {
    private final Customer customer;
    private final Item item;

    public Transaction(Customer customer, Item item) {
        this.customer = customer;
        this.item = item;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Item getItem() {
        return item;
    }
}
