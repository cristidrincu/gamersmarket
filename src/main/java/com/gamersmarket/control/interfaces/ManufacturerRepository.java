package com.gamersmarket.control.interfaces;

import java.util.List;

public interface ManufacturerRepository<T> {
    List<T> getAll();
    T getDetails(int manufacturerId);
    void add(T manufacturer);
    void delete(int manufacturerId);
}
