/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.control.translation;

import com.gamersmarket.common.interfaces.TranslationRepository;
import com.gamersmarket.entity.translation.TranslationMouse;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cristiandrincu
 */
public class MouseTranslationRepo implements TranslationRepository<TranslationMouse> {

    @PersistenceContext(name = "gamersMarket")
    private EntityManager em;
    
    @Override
    public TranslationMouse getTranslation(TranslationMouse translation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public TranslationMouse getTranslation(int translationId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addTranslation(TranslationMouse translation) {
        em.persist(translation);
    }

    @Override
    public void updateTranslation(TranslationMouse translation) {
        em.merge(translation);
    }

    @Override
    public void deleteTranslation(int translationId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }       
}
