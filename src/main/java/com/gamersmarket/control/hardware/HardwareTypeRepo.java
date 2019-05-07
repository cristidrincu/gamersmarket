package com.gamersmarket.control.hardware;

import com.gamersmarket.entity.types.HardwareType;
import com.gamersmarket.common.interfaces.HardwareRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class HardwareTypeRepo implements HardwareRepository<HardwareType> {

    @PersistenceContext(name = "gamersMarket")
    private EntityManager em;

    @Override
    public List<HardwareType> getItems() {
        return em.createNamedQuery(HardwareType.GET_HARDWARE_TYPES, HardwareType.class).getResultList();
    }

    @Override
    public HardwareType getItem(int hardwareId) {
        return em.createNamedQuery(HardwareType.GET_HARDWARE_TYPE, HardwareType.class)
                .setParameter(HardwareType.PARAM_ID, hardwareId)
                .getSingleResult();
    }

    @Override
    public void addItem(HardwareType hardwareItem) {
        em.persist(hardwareItem);
    }

    @Override
    public void deleteItem(int hardwareId) {
        HardwareType hwType = em.createNamedQuery(HardwareType.GET_HARDWARE_TYPE, HardwareType.class)
                .setParameter(HardwareType.PARAM_ID, hardwareId)
                .getSingleResult();
        em.remove(hwType);
    }
}
