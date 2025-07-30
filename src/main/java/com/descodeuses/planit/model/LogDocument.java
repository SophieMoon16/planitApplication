package com.descodeuses.planit.model;

import java.util.Date;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

@Document(collection ="LogDocument")
public class LogDocument {

    @Id
    private String id;
    private String text;
    private Date timestamp; 
    private Map<String, Object> extras = new HashMap<>();

    public LogDocument() {
        this.timestamp = new Date(); // Date et heure actuelles
    }// Initialisation de la date au moment de la création

     public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Date getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

      public Map<String, Object> getExtras() {
        return extras;
    }

    public void setExtras(Map<String, Object> extras) {
        this.extras = extras;
    }

     public void addExtra(String key, String value) {
        extras.put(key, value);
    }



}
