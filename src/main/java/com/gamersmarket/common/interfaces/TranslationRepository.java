/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.common.interfaces;

/**
 *
 * @author cristiandrincu
 */
public interface TranslationRepository<T> {
    T getTranslation(T translation);
    T getTranslation(int translationId);  
    void addTranslation(T translation);
    void updateTranslation(T translation);
    void deleteTranslation(int translationId);
}
