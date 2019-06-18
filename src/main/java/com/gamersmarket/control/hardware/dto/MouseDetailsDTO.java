package com.gamersmarket.control.hardware.dto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.gamersmarket.control.hardware.MouseRepo;
import com.gamersmarket.entity.hardware.Mouse;
import com.gamersmarket.common.utils.JsonUtils;
import com.gamersmarket.control.language.LanguageRepo;
import com.gamersmarket.control.translation.MouseTranslationRepo;
import com.gamersmarket.entity.language.Language;
import com.gamersmarket.entity.translation.TranslationMouse;
import java.text.MessageFormat;

import javax.inject.Inject;

public class MouseDetailsDTO {      
    
    private int mouseId;
    private String connectionType;
    private String sensorTechnology;
    private String buttons;
    private String scrollingButtons;
    private String colour;
    private String illumination;
    private String ledColour;
    private String cableLength;
    private String weight;
    private String dpi;
    private String wireless;
    
    @Inject
    private MouseRepo mouseRepo;
    
    @Inject
    private LanguageRepo languageRepo;
    
    @Inject
    private MouseTranslationRepo mouseTranslationRepo;
        
    @Inject
    public MouseDetailsDTO() {}
    
    public MouseDetailsDTO(Mouse mouse, TranslationMouse translation) {        
        this.mouseId = mouse.getId();
        this.connectionType = buildProperty(translation.getConnectionTypeTranslation(), mouse.getConnectionType());
        this.sensorTechnology = buildProperty(translation.getSensonTechnologyTranslation(), mouse.getSensorTechnology());
        this.buttons = buildProperty(translation.getButtonsTranslation(), mouse.getButtons());
        this.scrollingButtons = buildProperty(translation.getScrollingButtonsTranslation(), mouse.getScrollingButtons());
        this.colour = buildProperty(translation.getColourTranslation(), mouse.getColour());
        this.illumination = buildProperty(translation.getHasIlluminationTranslation(), mouse.getHasIllumination());
        this.ledColour = buildProperty(translation.getLedColorTranslation(), mouse.getLedColor());
        this.cableLength = buildProperty(translation.getCableLengthTranslation(), mouse.getCableLength());
        this.weight = buildProperty(translation.getWeightTranslation(), mouse.getWeight());
        this.dpi = buildProperty(translation.getDpiTranslation(), mouse.getDpi());
        this.wireless = buildProperty(translation.getIsWirelessTranslation(), mouse.getIsWireless());
    }

    public String buildMouseDetails(String language, int mouseId, JsonUtils jsonUtils) throws JsonProcessingException {
        Mouse mouse = mouseRepo.getItem(mouseId);
        Language lang = languageRepo.getLanguage(language);
        TranslationMouse translation = mouseTranslationRepo.getTranslation(mouseId, lang.getId());                        
        return jsonUtils.getProvider().getContext(MouseDetailsDTO.class).writeValueAsString(new MouseDetailsDTO(mouse, translation));
    }

    public int getMouseId() {
        return mouseId;
    }

    public String getConnectionType() {
        return connectionType;
    }

    public String getSensorTechnology() {
        return sensorTechnology;
    }

    public String getButtons() {
        return buttons;
    }

    public String getScrollingButtons() {
        return scrollingButtons;
    }

    public String getColour() {
        return colour;
    }

    public String getIllumination() {
        return illumination;
    }

    public String getLedColour() {
        return ledColour;
    }

    public String getCableLength() {
        return cableLength;
    }

    public String getWeight() {
        return weight;
    }

    public String getDpi() {
        return dpi;
    }

    public String getWireless() {
        return wireless;
    }
    
    private String buildProperty(String translation, String mouseProperty) {
        return translation + ": " + mouseProperty;
    }
    
    private String buildProperty(String translation, int mouseProperty) {
        return translation + ": " + mouseProperty;
    }
}
