package com.gamersmarket.control.interfaces;

public interface PricingRepository<T> {
    T getPricingDetailsForHardwareType(int pricing);
    void addPricing(T pricing);
    void addPricingToHardwareType(T pricingInformation, int hardwareTypeId);
}
