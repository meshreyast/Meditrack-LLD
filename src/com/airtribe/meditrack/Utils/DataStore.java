package com.airtribe.meditrack.Utils;

import java.util.*;

public class DataStore<T> {
    private final List<T> data = new ArrayList<>();

    public void add (T item) {
        data.add(item);
    }

    public void remove (T item) {
        data.remove(item);
    }

    public List<T> getAll () {
        return data;
    }
}
