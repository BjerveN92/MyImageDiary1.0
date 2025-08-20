package com.example.MyImageDiary10.services;

public abstract class ObjectService<T> {
    // create object
    public abstract T create(T obj);

    // read one object
    public abstract T getById(String id);

    // updates one object
    public abstract T update(String id, T obj);

    // deletes one object
    public abstract void delete(String id);

}
