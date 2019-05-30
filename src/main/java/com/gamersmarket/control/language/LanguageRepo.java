/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.control.language;

import com.gamersmarket.common.interfaces.BeanValidation;
import com.gamersmarket.common.interfaces.LanguageRepository;
import com.gamersmarket.entity.language.Language;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author cristiandrincu
 */
public class LanguageRepo implements LanguageRepository, BeanValidation {

    @PersistenceContext(name = "gamersMarket")
    private EntityManager em;  
    
    @Override
    public Language getLanguage(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Language getLanguage(String languageName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Language> getLanguages() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addLanguage(Language language) {
        //check if language is already in the database
        em.persist(language);
    }

    @Override
    public void updateLanguage(Language language) {
        //check if language is already in the database
        em.merge(language);
    }

    @Override
    public void deleteLanguage(int languageId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<String> collectConstraintViolationErrors(ConstraintViolationException e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
