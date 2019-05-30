/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.common.interfaces;

import com.gamersmarket.entity.language.Language;
import java.util.List;

/**
 *
 * @author cristiandrincu
 */
public interface LanguageRepository {
    Language getLanguage(int id);
    Language getLanguage(String languageName);
    List<Language> getLanguages();
    void addLanguage(Language language);
    void updateLanguage(Language language);
    void deleteLanguage(int languageId);
}
