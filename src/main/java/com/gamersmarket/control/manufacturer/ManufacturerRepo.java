package com.gamersmarket.control.manufacturer;

import com.gamersmarket.entity.manufacturer.Manufacturer;
import com.gamersmarket.common.interfaces.ManufacturerRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class ManufacturerRepo implements ManufacturerRepository<Manufacturer> {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Manufacturer> getAll() {
        return em.createNamedQuery(Manufacturer.GET_MANUFACTURERS, Manufacturer.class).getResultList();
    }

    @Override
    public Manufacturer getDetails(int manufacturerId) {
        return em.createNamedQuery(Manufacturer.GET_MANUFACTURER_DETAILS, Manufacturer.class)
                .setParameter("id", manufacturerId)
                .getSingleResult();
    }

    @Override
    public void add(Manufacturer manufacturer) {
        Manufacturer newManufacturer = new Manufacturer(manufacturer);
        em.persist(newManufacturer);
    }

    @Override
    public void delete(int manufacturerId) {
        Manufacturer manufacturer = em.createNamedQuery(Manufacturer.GET_MANUFACTURER_DETAILS, Manufacturer.class).setParameter("id", manufacturerId).getSingleResult();
        em.remove(manufacturer);
    }
}
