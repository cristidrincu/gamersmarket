package com.gamersmarket.common.interfaces;

import java.util.List;

public interface HardwareRepository<T> {
    List<T> getItems();
    T getItem(int hardwareId);
    T getItem(String language, int hardwareId);
    void addItem(T hardwareItem);
    void updateItem(T hardwareItem);
    void deleteItem(int hardwareId);
    void persistItemWithHardwareType(T hardwareItem, int hardwareTypeId, int gamerId);
}
