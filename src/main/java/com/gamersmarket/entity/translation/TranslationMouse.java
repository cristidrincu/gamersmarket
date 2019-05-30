/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.entity.translation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonNode;
import com.gamersmarket.entity.hardware.Mouse;
import com.gamersmarket.entity.language.Language;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author cristiandrincu
 */
@Entity
@Table(name = "translation_mouse")
public class TranslationMouse implements Serializable {
        
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_translation_mouse_generator")
    @SequenceGenerator(name = "sq_translation_mouse_generator", sequenceName = "sq_hardware_item")
    private int id;
    
    @Column(name = "text")
    private String translationText;        
    
    @Column(name = "connection_type_translation")
    private String connectionTypeTranslation;
    
    @Column(name = "sensor_technology_translation")
    private String sensonTechnologyTranslation;
    
    @Column(name = "buttons_translation")
    private String buttonsTranslation;
    
    @Column(name = "scrolling_buttons_translation")
    private String scrollingButtonsTranslation;
    
    @Column(name = "colour_translation")
    private String colourTranslation;
    
    @Column(name = "has_illumination_translation")
    private String hasIlluminationTranslation;
    
    @Column(name = "led_color_translation")
    private String ledColorTranslation;
    
    @Column(name = "cable_length_translation")
    private String cableLengthTranslation;
    
    @Column(name = "weight_translation")
    private String weightTranslation;
    
    @Column(name = "dpi_translation")
    private String dpiTranslation;
    
    @Column(name = "is_wireless_translation")
    private String isWirelessTranslation;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private Date createdOn = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_on")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private Date updatedOn;
    
    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;
    
    @ManyToOne
    @JoinColumn(name = "mouse_id")
    private Mouse mouse;

    public TranslationMouse() {}
    
    public TranslationMouse(JsonNode translationNode) {
        this.translationText = translationNode.get("translation").asText();
        this.updatedOn = new Date();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTranslationText() {
        return translationText;
    }

    public void setTranslationText(String translationText) {
        this.translationText = translationText;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getConnectionTypeTranslation() {
        return connectionTypeTranslation;
    }

    public void setConnectionTypeTranslation(String connectionTypeTranslation) {
        this.connectionTypeTranslation = connectionTypeTranslation;
    }

    public String getSensonTechnologyTranslation() {
        return sensonTechnologyTranslation;
    }

    public void setSensonTechnologyTranslation(String sensonTechnologyTranslation) {
        this.sensonTechnologyTranslation = sensonTechnologyTranslation;
    }

    public String getButtonsTranslation() {
        return buttonsTranslation;
    }

    public void setButtonsTranslation(String buttonsTranslation) {
        this.buttonsTranslation = buttonsTranslation;
    }

    public String getScrollingButtonsTranslation() {
        return scrollingButtonsTranslation;
    }

    public void setScrollingButtonsTranslation(String scrollingButtonsTranslation) {
        this.scrollingButtonsTranslation = scrollingButtonsTranslation;
    }

    public String getColourTranslation() {
        return colourTranslation;
    }

    public void setColourTranslation(String colourTranslation) {
        this.colourTranslation = colourTranslation;
    }

    public String getHasIlluminationTranslation() {
        return hasIlluminationTranslation;
    }

    public void setHasIlluminationTranslation(String hasIlluminationTranslation) {
        this.hasIlluminationTranslation = hasIlluminationTranslation;
    }

    public String getLedColorTranslation() {
        return ledColorTranslation;
    }

    public void setLedColorTranslation(String ledColorTranslation) {
        this.ledColorTranslation = ledColorTranslation;
    }

    public String getCableLengthTranslation() {
        return cableLengthTranslation;
    }

    public void setCableLengthTranslation(String cableLengthTranslation) {
        this.cableLengthTranslation = cableLengthTranslation;
    }

    public String getWeightTranslation() {
        return weightTranslation;
    }

    public void setWeightTranslation(String weightTranslation) {
        this.weightTranslation = weightTranslation;
    }

    public String getDpiTranslation() {
        return dpiTranslation;
    }

    public void setDpiTranslation(String dpiTranslation) {
        this.dpiTranslation = dpiTranslation;
    }

    public String getIsWirelessTranslation() {
        return isWirelessTranslation;
    }

    public void setIsWirelessTranslation(String isWirelessTranslation) {
        this.isWirelessTranslation = isWirelessTranslation;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }        

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }        
}
