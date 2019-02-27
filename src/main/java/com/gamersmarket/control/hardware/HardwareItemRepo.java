package com.gamersmarket.control.hardware;

import com.gamersmarket.entity.hardware.HardwareItem;
import com.gamersmarket.entity.types.HardwareType;
import com.gamersmarket.common.interfaces.HardwareRepository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class HardwareItemRepo implements HardwareRepository<HardwareItem> {

    private HardwareTypeRepo hardwareTypeRepo;

    @PersistenceContext
    EntityManager em;

    @Inject
    public HardwareItemRepo(HardwareTypeRepo hardwareTypeRepo) {
        this.hardwareTypeRepo = hardwareTypeRepo;
    }

    @Override
    public List<HardwareItem> getItems() {
        return null;
    }

    @Override
    public HardwareItem getItem(int hardwareId) {
        return em.createNamedQuery(HardwareItem.GET_HARDWARE_ITEM, HardwareItem.class).setParameter("id", hardwareId).getSingleResult();
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

    protected HardwareItem addTypeToHardwareItem(HardwareItem hwItem, int hardwareTypeId) {
        HardwareType type = hardwareTypeRepo.getItem(hardwareTypeId);
        hwItem.setHardwareType(type);

        return hwItem;
    }
}
