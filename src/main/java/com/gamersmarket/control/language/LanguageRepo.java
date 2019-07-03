/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.control.language;

import com.gamersmarket.common.enums.language.Languages;
import com.gamersmarket.common.interfaces.BeanValidation;
import com.gamersmarket.common.interfaces.LanguageRepository;
import com.gamersmarket.common.utils.exceptions.persistence.DuplicateEntryException;
import com.gamersmarket.common.utils.exceptions.persistence.NoEntityFoundException;
import com.gamersmarket.entity.language.Language;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author cristiandrincu
 */
public class LanguageRepo implements LanguageRepository, BeanValidation {

    private static final Logger LOGGER = Logger.getLogger(LanguageRepo.class.getName());       
    
    @PersistenceContext(name = "gamersMarket")
    private EntityManager em;  
    
    @Override
    public Language getLanguage(int id) {
        return em.find(Language.class, id);
    }

    @Override
    public Language getLanguage(String languageName) {        
        try {
            return em.createNamedQuery(Language.GET_LANG_BASED_ON_LANG_NAME, Language.class)
                .setParameter(Language.LANG_NAME_PARAM, languageName).getSingleResult();
        } catch (NoResultException ex) {
            LOGGER.log(Level.WARNING, "No language found based on provided language name. Switching to default language.");
            return new Language(Languages.DEFAULT_LANGUAGE.getLanguage());
        }        
    }

    @Override
    public List<Language> getLanguages() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addLanguage(Language language) {
        Language lang = getLanguage(language.getLanguage());
        if (Objects.nonNull(lang)) {
            throw new DuplicateEntryException("The language you are trying to add has already been persisted.");
        } else {
            em.persist(language);
        }        
    }

    @Override
    public void updateLanguage(Language language) {
        Language lang = getLanguage(language.getId());
        if (Objects.nonNull(lang)) {
            em.merge(language);
        } else {
            throw new NoEntityFoundException("The language you are trying to update does not exist.");
        }        
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
