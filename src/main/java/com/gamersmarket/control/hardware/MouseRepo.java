package com.gamersmarket.control.hardware;

import com.gamersmarket.common.enums.messages.BeanValidationMessages;
import com.gamersmarket.common.enums.messages.HardwareItemMessages;
import com.gamersmarket.common.interfaces.BeanValidation;
import com.gamersmarket.entity.hardware.Mouse;
import com.gamersmarket.common.interfaces.HardwareRepository;
import com.gamersmarket.common.utils.exceptions.persistence.EntityValidationException;
import com.gamersmarket.common.utils.exceptions.persistence.NoEntityFoundException;
import com.gamersmarket.control.gamers.GamersRepo;
import com.gamersmarket.entity.gamers.Gamer;
import com.gamersmarket.entity.types.HardwareType;
import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.validation.ConstraintViolationException;

public class MouseRepo implements HardwareRepository<Mouse>, BeanValidation {   

    @PersistenceContext(name = "gamersMarket")
    private EntityManager em;
    
    @Inject
    private HardwareTypeRepo hardwareTypeRepo;
    
    @Inject
    private GamersRepo gamersRepo;

    @Override
    public List<Mouse> getItems() {
        return em.createNamedQuery(Mouse.GET_MICE, Mouse.class).getResultList();
    }

    @Override
    public Mouse getItem(int hardwareId) {
        try {
            return em.createNamedQuery(Mouse.GET_MOUSE_DETAILS, Mouse.class).setParameter(Mouse.MOUSE_PARAM_ID, hardwareId).getSingleResult();
        } catch (NoResultException e) {
            throw new NoEntityFoundException(HardwareItemMessages.HARDWARE_ITEM_NOT_FOUND_BY_ID.getMessage());
        }        
    }

    @Override
    public void addItem(Mouse hardwareItem) {
        try {
            em.persist(hardwareItem);
        } catch (ConstraintViolationException e) {                        
            throw new EntityValidationException(BeanValidationMessages.FAILED_CONSTRAINT_VALIDATION.getMessage(), 
                    collectConstraintViolationErrors(e));
        }        
    }
    
    @Override
    public void updateItem(Mouse hardwareItem) {
        em.merge(hardwareItem);
    }

    @Override    
    public void deleteItem(int hardwareId) {
        Mouse mouse = getItem(hardwareId);        
        em.remove(mouse);        
    }
    
    @Override
    public void persistItemWithHardwareType(Mouse mouse, int hardwareTypeId, int gamerId) {
        HardwareType hardwareType = hardwareTypeRepo.getItem(hardwareTypeId);
        Gamer gamer = gamersRepo.getGamerDetails(gamerId);       
        mouse.setHardwareType(hardwareType);
        mouse.setGamer(gamer);
        addItem(mouse);
    }

    @Override
    public Set<String> collectConstraintViolationErrors(ConstraintViolationException e) {
        Set<String> constraintViolations = new HashSet<>();
        e.getConstraintViolations().forEach(violation -> constraintViolations.add(violation.getMessageTemplate()));
        return constraintViolations;
    }
}
