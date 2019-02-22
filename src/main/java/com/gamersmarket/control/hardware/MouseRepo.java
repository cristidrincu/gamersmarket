package com.gamersmarket.control.hardware;

import com.gamersmarket.entity.hardware.HardwareItem;
import com.gamersmarket.entity.hardware.Mouse;
import com.gamersmarket.control.interfaces.HardwareItemRepository;
import com.gamersmarket.control.interfaces.HardwareRepository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class MouseRepo implements HardwareRepository<Mouse>, HardwareItemRepository<Mouse> {

    @Inject
    HardwareItemRepo hardwareItemRepo;

    @PersistenceContext(name = "gamersMarket")
    EntityManager em;

    @Override
    public List<Mouse> getItems() {
        return em.createNamedQuery(Mouse.GET_ITEMS, Mouse.class).getResultList();
    }

    @Override
    public Mouse getItem(int hardwareId) {
        return em.createNamedQuery(Mouse.GET_MOUSE_DETAILS, Mouse.class).setParameter("id", hardwareId).getSingleResult();
    }

    @Override
    public void addItem(Mouse hardwareItem) {
        em.persist(hardwareItem);
    }

    @Override
    public void deleteItem(int hardwareId) {
        Mouse mouse = em.createNamedQuery(Mouse.GET_MOUSE_DETAILS, Mouse.class).setParameter("id", hardwareId).getSingleResult();
        em.remove(mouse);
    }

    @Override
    public void persistItemWithHardwareType(Mouse mouse, HardwareItem hardwareItemJson, int hardwareTypeId) {
        HardwareItem hwItem = hardwareItemRepo.addTypeToHardwareItem(hardwareItemJson, hardwareTypeId);
        mouse.setHardwareItem(hwItem);
        hardwareItemRepo.addItem(hwItem);
        addItem(mouse);
    }
}
