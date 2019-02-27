package com.gamersmarket.common.interfaces;

import java.util.List;

public interface HardwareRepository<T> {
    List<T> getItems();
    T getItem(int hardwareId);
    void addItem(T hardwareItem);
    void deleteItem(int hardwareId);
}
