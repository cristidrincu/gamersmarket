package com.gamersmarket.control.hardware;

import com.gamersmarket.entity.hardware.Mouse;
import com.gamersmarket.common.interfaces.HardwareRepository;
import com.gamersmarket.entity.types.HardwareType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.inject.Inject;

public class MouseRepo implements HardwareRepository<Mouse> {   

    @PersistenceContext(name = "gamersMarket")
    private EntityManager em;
    
    @Inject
    private HardwareTypeRepo hardwareTypeRepo;

    @Override
    public List<Mouse> getItems() {
        return em.createNamedQuery(Mouse.GET_MICE, Mouse.class).getResultList();
    }

    @Override
    public Mouse getItem(int hardwareId) {
        return em.createNamedQuery(Mouse.GET_MOUSE_DETAILS, Mouse.class).setParameter(Mouse.MOUSE_PARAM_ID, hardwareId).getSingleResult();
    }

    @Override
    public void addItem(Mouse hardwareItem) {
        em.persist(hardwareItem);       
    }

    @Override    
    public void deleteItem(int hardwareId) {
        Mouse mouse = getItem(hardwareId);        
        em.remove(mouse);        
    }
    
    public void persistItemWithHardwareType(Mouse mouse, int hardwareTypeId) {
        HardwareType hardwareType = hardwareTypeRepo.getItem(hardwareTypeId);
        mouse.setHardwareType(hardwareType);
        addItem(mouse);
    }
}
