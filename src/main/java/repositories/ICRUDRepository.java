package repositories;


import models.Producto;

import java.util.List;

public interface ICRUDRepository<T, ID> {
    List<T> findAll();

    T insert(T entity);

    T update(T entity);

    T findById(ID id);

    T deleteById(ID id);

    Producto delete(Producto producto);
}