package com.example.PracticaMongo.Service;

import java.io.Serializable;
import java.util.List;


public interface GenericService <T, ID extends Serializable>{
    public T save(T entity);
    public T findById(ID id);

    List<T> finfByAll();


    public void delete (ID id);

}
