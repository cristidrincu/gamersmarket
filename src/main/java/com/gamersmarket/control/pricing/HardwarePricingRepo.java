package com.gamersmarket.control.pricing;

import com.gamersmarket.entity.pricing.HardwarePricing;
import com.gamersmarket.entity.types.HardwareType;
import com.gamersmarket.control.interfaces.PricingRepository;

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
    public void addPricingToHardwareType(HardwarePricing pricingInformation, int hardwareTypeId) {
        HardwarePricing pricing = new HardwarePricing(pricingInformation);
        HardwareType hwType = em.createNamedQuery(HardwareType.GET_HARDWARE_TYPE, HardwareType.class).setParameter("id", hardwareTypeId).getSingleResult();
        pricing.setHardwareType(hwType);
        em.persist(pricing);
    }
}
