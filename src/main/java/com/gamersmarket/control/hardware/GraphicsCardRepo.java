package com.gamersmarket.control.hardware;

import com.gamersmarket.entity.hardware.GraphicsCard;
import com.gamersmarket.entity.hardware.HardwareItem;
import com.gamersmarket.common.interfaces.HardwareRepository;
import com.gamersmarket.control.gamers.GamersRepo;
import com.gamersmarket.entity.gamers.Gamer;
import com.gamersmarket.entity.types.HardwareType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.inject.Inject;

public class GraphicsCardRepo implements HardwareRepository<GraphicsCard> {  

    @PersistenceContext(name = "gamersMarket")
    private EntityManager em;  
    
    @Inject
    HardwareTypeRepo hwTypeRepo;
    
    @Inject
    GamersRepo gamersRepo;

    @Override
    public List<GraphicsCard> getItems() {
        return em.createNamedQuery(GraphicsCard.GET_ITEMS, GraphicsCard.class).getResultList();
    }

    @Override
    public GraphicsCard getItem(int hardwareId) {
        return em.createNamedQuery(GraphicsCard.GET_ITEM, GraphicsCard.class).setParameter("id", hardwareId).getSingleResult();
    }

    @Override
    public void addItem(GraphicsCard hardwareItem) {
        em.persist(hardwareItem);
    }
    
    @Override
    public void updateItem(GraphicsCard graphicsCard) {
        em.merge(graphicsCard);
    }

    @Override
    public void deleteItem(int hardwareId) {
        GraphicsCard graphicsCard = getItem(hardwareId);
        em.remove(graphicsCard);
    }
    
    public void persistItemWithHardwareType(GraphicsCard graphicsCard, HardwareItem hardwareItemJson, int hardwareTypeId) {                        
        addItem(graphicsCard);
    }

    @Override
    public void persistItemWithHardwareType(GraphicsCard graphicsCard, int hardwareTypeId, int gamerId) {
        HardwareType hwType = hwTypeRepo.getItem(hardwareTypeId);
        Gamer gamer = gamersRepo.getGamerDetails(gamerId);        
        graphicsCard.setHardwareType(hwType);
        graphicsCard.setGamer(gamer);        
        addItem(graphicsCard);    
    }
}
