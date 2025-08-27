package com.example.MyImageDiary10.services;

public abstract class ObjectService<Response, Request, Update> {
    // create object (INDATA = request)
    public abstract Response create(Request obj);

    // read one object (OUTDATA = response)
    public abstract Response getById(String id);

    // updates one object
    public abstract Response update(String id, Update obj);

    // deletes one object
    public abstract void delete(String id);

}
