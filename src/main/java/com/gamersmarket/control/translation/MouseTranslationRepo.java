/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.control.translation;

import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.common.interfaces.BeanValidation;
import com.gamersmarket.common.interfaces.TranslationRepository;
import com.gamersmarket.control.hardware.MouseRepo;
import com.gamersmarket.control.language.LanguageRepo;
import com.gamersmarket.entity.hardware.Mouse;
import com.gamersmarket.entity.language.Language;
import com.gamersmarket.entity.translation.TranslationMouse;
import java.util.Set;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author cristiandrincu
 */
public class MouseTranslationRepo implements TranslationRepository<TranslationMouse>, BeanValidation {

    @PersistenceContext(name = "gamersMarket")
    private EntityManager em;
    
    @Inject
    private LanguageRepo languageRepo;
    
    @Inject
    private MouseRepo mouseRepo;
    
    @Inject
    public MouseTranslationRepo() {}
    
    @Override
    public TranslationMouse getTranslation(TranslationMouse translation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public TranslationMouse getTranslation(int translationId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }          

    @Override
    public void addTranslation(JsonNode rootNode, String language, int mouseId) {        
        Language lang = languageRepo.getLanguage(language);
        Mouse mouse = mouseRepo.getItem(mouseId);
        TranslationMouse translation = new TranslationMouse(rootNode);
        translation.setLanguage(lang);
        translation.setMouse(mouse);
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

    @Override
    public Set<String> collectConstraintViolationErrors(ConstraintViolationException e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
