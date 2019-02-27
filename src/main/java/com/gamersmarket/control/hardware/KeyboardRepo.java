package com.gamersmarket.control.hardware;

import com.gamersmarket.common.interfaces.HardwareItemRepository;
import com.gamersmarket.common.interfaces.HardwareRepository;
import com.gamersmarket.entity.hardware.HardwareItem;
import com.gamersmarket.entity.hardware.Keyboard;

import java.util.List;

public class KeyboardRepo implements HardwareRepository<Keyboard>, HardwareItemRepository<Keyboard> {

    @Override
    public List<Keyboard> getItems() {
        return null;
    }

    @Override
    public Keyboard getItem(int hardwareId) {
        return null;
    }

    @Override
    public void addItem(Keyboard hardwareItem) {

    }

    @Override
    public void deleteItem(int hardwareId) {

    }

    @Override
    public void persistItemWithHardwareType(Keyboard item, HardwareItem hardwareItemJson, int hardwareTypeId) {

    }
}
