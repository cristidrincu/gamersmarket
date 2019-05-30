package com.gamersmarket.control.hardware;

import com.gamersmarket.common.enums.messages.BeanValidationMessages;
import com.gamersmarket.common.interfaces.BeanValidation;
import com.gamersmarket.common.interfaces.HardwareRepository;
import com.gamersmarket.common.utils.exceptions.persistence.EntityValidationException;
import com.gamersmarket.control.gamers.GamersRepo;
import com.gamersmarket.entity.gamers.Gamer;
import com.gamersmarket.entity.hardware.Keyboard;
import com.gamersmarket.entity.types.HardwareType;
import java.util.HashSet;

import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;

public class KeyboardRepo implements HardwareRepository<Keyboard>, BeanValidation {

    @PersistenceContext(name = "gamersMarket")
    private EntityManager em;
    
    @Inject
    private HardwareTypeRepo hardwareTypeRepo;
    
    @Inject
    private GamersRepo gamersRepo;
    
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
       try {
          em.persist(hardwareItem); 
       } catch (ConstraintViolationException e) {            
          throw new EntityValidationException(BeanValidationMessages.FAILED_CONSTRAINT_VALIDATION.getMessage(), 
                  collectConstraintViolationErrors(e));
       }       
    }
    
    @Override
    public void updateItem(Keyboard hardwareItem) {
        em.merge(hardwareItem);
    }

    @Override
    public void deleteItem(int hardwareId) {
       Keyboard keyboard = getItem(hardwareId);
       em.remove(keyboard);
    }
    
    @Override
    public void persistItemWithHardwareType(Keyboard keyboard, int hardwareTypeId, int gamerId) {
        HardwareType hardwareType = hardwareTypeRepo.getItem(hardwareTypeId);
        Gamer gamer = gamersRepo.getGamerDetails(gamerId);
        keyboard.setHardwareType(hardwareType);
        keyboard.setGamer(gamer);
        addItem(keyboard);
    }

    @Override
    public Set<String> collectConstraintViolationErrors(ConstraintViolationException e) {
        Set<String> constraintViolations = new HashSet<>();
        e.getConstraintViolations().forEach(violation -> constraintViolations.add(violation.getMessageTemplate()));
        return constraintViolations;
    }
}
