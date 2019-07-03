/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gamersmarket.entity.language;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author cristiandrincu
 */
@Entity
@Table(name = "languages")
@NamedQueries({
    @NamedQuery(name = Language.GET_LANG_BASED_ON_LANG_NAME, query = Language.GET_LANG_BASED_ON_LANG_NAME_QUERY)
})
public class Language implements Serializable {
 
    public static final String LANG_NAME_PARAM = "langParam";
    public static final String GET_LANG_BASED_ON_LANG_NAME = "getLangBasedOnLangNameParam";
    public static final String GET_LANG_BASED_ON_LANG_NAME_QUERY = "select lang from Language lang where lang.language =:" + LANG_NAME_PARAM;
    
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_language_generator")
    @SequenceGenerator(name = "sq_language_generator", sequenceName = "sq_hardware_item")
    private int id;
    
    @Column(name = "language_name")
    @Size(min = 2, max = 5, message = "The language identifier must be between 2 and 5 characters long.")
    private String language;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private Date createdOn = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_on")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private Date updatedOn;

    public Language() {}
    
    public Language(JsonNode languageNode) {
        this.language = languageNode.get("language").asText();
        this.updatedOn = new Date();
    }
    
    public Language(String language) {
        this.language = language;
        this.updatedOn = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
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
