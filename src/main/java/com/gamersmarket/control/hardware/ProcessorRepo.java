package com.gamersmarket.control.hardware;

import com.gamersmarket.common.enums.messages.BeanValidationMessages;
import com.gamersmarket.common.interfaces.BeanValidation;
import com.gamersmarket.common.interfaces.HardwareRepository;
import com.gamersmarket.common.utils.exceptions.persistence.EntityValidationException;
import com.gamersmarket.control.gamers.GamersRepo;
import com.gamersmarket.entity.gamers.Gamer;
import com.gamersmarket.entity.hardware.Processor;
import com.gamersmarket.entity.types.HardwareType;
import java.util.HashSet;

import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;

public class ProcessorRepo implements HardwareRepository<Processor>, BeanValidation {

    @PersistenceContext(name = "gamersMarket")
    private EntityManager em;
    
    @Inject
    HardwareTypeRepo hwTypeRepo;
    
    @Inject
    GamersRepo gamersRepo;
    
    @Override
    public List<Processor> getItems() {
        return null;
    }

    @Override
    public Processor getItem(int hardwareId) {
        return null;
    }

    @Override
    public void addItem(Processor hardwareItem) {
        try {
            em.persist(hardwareItem);
        } catch (ConstraintViolationException e) {            
            throw new EntityValidationException(BeanValidationMessages.FAILED_CONSTRAINT_VALIDATION.getMessage(), 
                    collectConstraintViolationErrors(e));
        }
        
    }
    
    @Override
    public void updateItem(Processor hardwareItem) {
        em.merge(hardwareItem);
    }

    @Override
    public void deleteItem(int hardwareId) {

    }   

    @Override
    public void persistItemWithHardwareType(Processor processor, int hardwareTypeId, int gamerId) {
        HardwareType hardwareType = hwTypeRepo.getItem(hardwareTypeId);
        Gamer gamer = gamersRepo.getGamerDetails(gamerId);        
        processor.setHardwareType(hardwareType);
        processor.setGamer(gamer);
        addItem(processor);
    }

    @Override
    public Set<String> collectConstraintViolationErrors(ConstraintViolationException e) {
        Set<String> constraintViolations = new HashSet<>();
        e.getConstraintViolations().forEach(violation -> constraintViolations.add(violation.getMessageTemplate()));
        return constraintViolations;
    }
}
