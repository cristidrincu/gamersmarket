package com.gamersmarket.control.hardware;

import com.gamersmarket.common.interfaces.HardwareItemRepository;
import com.gamersmarket.common.interfaces.HardwareRepository;
import com.gamersmarket.entity.hardware.HardwareItem;
import com.gamersmarket.entity.hardware.Processor;

import java.util.List;

public class ProcessorRepo implements HardwareRepository<Processor>, HardwareItemRepository<Processor> {

    @Override
    public List<Processor> getItems() {
        return null;
    }

    @Override
    public Processor getItem(int hardwareId) {
        return null;
    }

    @Override
    public void addItem(Processor hardwareItem) {

    }

    @Override
    public void deleteItem(int hardwareId) {

    }

    @Override
    public void persistItemWithHardwareType(Processor item, HardwareItem hardwareItemJson, int hardwareTypeId) {

    }
}
