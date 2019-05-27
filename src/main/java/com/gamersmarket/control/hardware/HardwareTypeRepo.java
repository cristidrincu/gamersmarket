package com.gamersmarket.control.hardware;

import com.gamersmarket.common.enums.messages.BeanValidationMessages;
import com.gamersmarket.common.interfaces.BeanValidation;
import com.gamersmarket.entity.types.HardwareType;
import com.gamersmarket.common.interfaces.HardwareRepository;
import com.gamersmarket.common.utils.exceptions.EntityValidationException;
import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolationException;

public class HardwareTypeRepo implements HardwareRepository<HardwareType>, BeanValidation {

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
        try {
            em.persist(hardwareItem);
        } catch (ConstraintViolationException e) {            
            throw new EntityValidationException(BeanValidationMessages.FAILED_CONSTRAINT_VALIDATION.getMessage(), 
                    collectConstraintViolationErrors(e));
       }        
    }
    
    @Override
    public void updateItem(HardwareType hardwareType) {
        em.merge(hardwareType);
    }

    @Override
    public void deleteItem(int hardwareId) {
        HardwareType hwType = em.createNamedQuery(HardwareType.GET_HARDWARE_TYPE, HardwareType.class)
                .setParameter(HardwareType.PARAM_ID, hardwareId)
                .getSingleResult();
        em.remove(hwType);
    }        

    @Override
    public void persistItemWithHardwareType(HardwareType hardwareItem, int hardwareTypeId, int gamerId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Set<String> collectConstraintViolationErrors(ConstraintViolationException e) {
        Set<String> constraintViolations = new HashSet<>();
        e.getConstraintViolations().forEach(violation -> constraintViolations.add(violation.getMessageTemplate()));
        return constraintViolations;
    }
}
