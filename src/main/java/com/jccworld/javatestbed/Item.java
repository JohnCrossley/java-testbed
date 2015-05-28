package com.jccworld.javatestbed;

/**
 * Created by john.crossley on 27/05/2015.
 */
public class Item {
    private final String id;
    private final String name;

    public Item(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
