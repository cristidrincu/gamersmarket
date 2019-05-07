package com.gamersmarket.control.hardware;

import com.gamersmarket.entity.hardware.HardwareItem;
import com.gamersmarket.common.interfaces.HardwareRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class HardwareItemRepo implements HardwareRepository<HardwareItem> {   

    @PersistenceContext(name = "gamersMarket")
    private EntityManager em;

    public HardwareItemRepo() {};   

    @Override
    public List<HardwareItem> getItems() {
        return em.createNamedQuery(HardwareItem.GET_HARDWARE_ITEMS, HardwareItem.class).getResultList();
    }

    @Override
    public HardwareItem getItem(int hardwareId) {
        return em.createNamedQuery(HardwareItem.GET_HARDWARE_ITEM, HardwareItem.class).setParameter(HardwareItem.PARAM_ID, hardwareId).getSingleResult();
    }

    @Override
    public void addItem(HardwareItem hwItem) {
        em.persist(hwItem);        
    }

    @Override
    public void deleteItem(int hardwareId) {
        HardwareItem hwItem = getItem(hardwareId);
        em.remove(hwItem);        
    }   
}
