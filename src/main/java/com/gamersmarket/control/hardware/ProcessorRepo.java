package com.gamersmarket.control.hardware;

import com.gamersmarket.common.interfaces.HardwareItemRepository;
import com.gamersmarket.common.interfaces.HardwareRepository;
import com.gamersmarket.entity.hardware.HardwareItem;
import com.gamersmarket.entity.hardware.Processor;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ProcessorRepo implements HardwareRepository<Processor>, HardwareItemRepository<Processor> {

    @PersistenceContext(name = "gamersMarket")
    private EntityManager em;
    
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
        em.persist(hardwareItem);
    }
    
    @Override
    public void updateItem(Processor hardwareItem) {
        em.merge(hardwareItem);
    }

    @Override
    public void deleteItem(int hardwareId) {

    }

    @Override
    public void persistItemWithHardwareType(Processor item, HardwareItem hardwareItemJson, int hardwareTypeId) {

    }
}
