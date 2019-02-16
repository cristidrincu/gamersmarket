package com.gamersmarket.control.hardware;

import com.gamersmarket.entity.hardware.GraphicsCard;
import com.gamersmarket.entity.hardware.HardwareItem;
import com.gamersmarket.control.interfaces.HardwareItemRepository;
import com.gamersmarket.control.interfaces.HardwareRepository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class GraphicsCardRepo implements HardwareRepository<GraphicsCard>, HardwareItemRepository<GraphicsCard> {

    private HardwareItemRepo hardwareItemRepo;

    @PersistenceContext
    EntityManager em;

    @Inject
    public GraphicsCardRepo(HardwareItemRepo hardwareItemRepo) {
        this.hardwareItemRepo = hardwareItemRepo;
    }

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
    public void deleteItem(int hardwareId) {
        GraphicsCard graphicsCard = getItem(hardwareId);
        em.remove(graphicsCard);
    }

    @Override
    public void persistItemWithHardwareType(GraphicsCard graphicsCard, HardwareItem hardwareItemJson, int hardwareTypeId) {
        HardwareItem hwItem = hardwareItemRepo.addTypeToHardwareItem(hardwareItemJson, hardwareTypeId);
        graphicsCard.setHardwareItem(hwItem);
        hardwareItemRepo.addItem(hwItem);
        addItem(graphicsCard);
    }
}
