package com.example.stockhandling.stockhandling.repository;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRepository<T> {

    protected List<T> list = new ArrayList<>();

    public synchronized T save(T t){
        list.add(t);

        return t;
    }
}
