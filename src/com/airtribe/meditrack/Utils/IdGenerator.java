package com.airtribe.meditrack.Utils;

public class IdGenerator {

    private static final IdGenerator Instance = new IdGenerator();

    private int counter;

    private IdGenerator () {};

    static {
        System.out.println("IdGenerator loaded");
    }

    public static IdGenerator getInstance () {
        return Instance;
    }

    public synchronized int generateId() {
        return ++counter;
    }
}
