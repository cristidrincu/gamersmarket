package com.gamersmarket.control.hardware;

import com.gamersmarket.common.enums.messages.BeanValidationMessages;
import com.gamersmarket.common.interfaces.BeanValidation;
import com.gamersmarket.entity.hardware.HardwareItem;
import com.gamersmarket.common.interfaces.HardwareRepository;
import com.gamersmarket.common.utils.exceptions.EntityValidationException;
import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolationException;

public class HardwareItemRepo implements HardwareRepository<HardwareItem>, BeanValidation {   

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
        try {
            em.persist(hwItem);
        } catch (ConstraintViolationException e) {
            throw new EntityValidationException(BeanValidationMessages.FAILED_CONSTRAINT_VALIDATION.getMessage(), 
                    collectConstraintViolationErrors(e));
        }        
    }
    
    @Override
    public void updateItem(HardwareItem hwItem) {
        em.merge(hwItem);
    }

    @Override
    public void deleteItem(int hardwareId) {
        HardwareItem hwItem = getItem(hardwareId);
        em.remove(hwItem);        
    }   

    @Override
    public void persistItemWithHardwareType(HardwareItem hardwareItem, int hardwareTypeId, int gamerId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<String> collectConstraintViolationErrors(ConstraintViolationException e) {
        Set<String> constraintViolations = new HashSet<>();
        e.getConstraintViolations().forEach(violation -> constraintViolations.add(violation.getMessageTemplate()));
        return constraintViolations;
    }
}
