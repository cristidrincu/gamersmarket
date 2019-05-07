package com.gamersmarket.control.pricing;

import com.gamersmarket.entity.hardware.HardwareItem;
import com.gamersmarket.entity.pricing.HardwarePricing;
import com.gamersmarket.common.interfaces.PricingRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class HardwarePricingRepo implements PricingRepository<HardwarePricing> {

    @PersistenceContext
    EntityManager em;

    @Override
    public HardwarePricing getPricingDetailsForHardwareType(int pricing) {
        return null;
    }

    @Override
    public void addPricing(HardwarePricing pricing) {
        em.persist(new HardwarePricing(pricing));
    }

    @Override
    public void addPricingToHardwareType(HardwarePricing pricingInformation, int hardwareItemId) {
        HardwarePricing pricing = new HardwarePricing(pricingInformation);
        HardwareItem hwItem = em.createNamedQuery(HardwareItem.GET_HARDWARE_ITEM, HardwareItem.class).setParameter("id", hardwareItemId).getSingleResult();
        pricing.setHardwareItem(hwItem);
        em.persist(pricing);
    }
}
