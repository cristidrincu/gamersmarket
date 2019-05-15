package com.gamersmarket.control.hardware;

import com.gamersmarket.entity.hardware.GraphicsCard;
import com.gamersmarket.entity.hardware.HardwareItem;
import com.gamersmarket.common.interfaces.HardwareRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class GraphicsCardRepo implements HardwareRepository<GraphicsCard> {  

    @PersistenceContext(name = "gamersMarket")
    private EntityManager em;   

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
}
