package com.gamersmarket.control.hardware;

import com.gamersmarket.common.interfaces.HardwareRepository;
import com.gamersmarket.entity.hardware.Keyboard;
import com.gamersmarket.entity.types.HardwareType;

import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class KeyboardRepo implements HardwareRepository<Keyboard> {

    @PersistenceContext(name = "gamersMarket")
    private EntityManager em;
    
    @Inject
    private HardwareTypeRepo hardwareTypeRepo;
    
    @Override
    public List<Keyboard> getItems() {
        return em.createNamedQuery(Keyboard.FIND_ALL_KEYBOARDS, Keyboard.class).getResultList();
    }

    @Override
    public Keyboard getItem(int hardwareId) {
        return em.createNamedQuery(Keyboard.FIND_KEYBOARD_BY_ID, Keyboard.class)
                .setParameter(Keyboard.KEYBOARD_PARAM_ID, hardwareId)
                .getSingleResult();
    }

    @Override
    public void addItem(Keyboard hardwareItem) {
       em.persist(hardwareItem); 
    }

    @Override
    public void deleteItem(int hardwareId) {
       Keyboard keyboard = getItem(hardwareId);
       em.remove(keyboard);
    }
    
    public void persistItemWithHardwareType(Keyboard keyboard, int hardwareTypeId) {
        HardwareType hardwareType = hardwareTypeRepo.getItem(hardwareTypeId);
        keyboard.setHardwareType(hardwareType);
        addItem(keyboard);
    }
}
