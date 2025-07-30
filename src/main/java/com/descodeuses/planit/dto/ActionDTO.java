package com.descodeuses.planit.dto;

import java.time.LocalDate;

public class ActionDTO {

   private Long id;
    private String title;
    private boolean completed;
    private String priorite;
    private LocalDate dueDate;
    

    // Constructor with fields
    public ActionDTO(Long id, String title, boolean completed, String priorite, LocalDate dueDate) {
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.priorite = priorite;
        this.dueDate = dueDate;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getPriorite() {
        return priorite;
    }

    public void setPriorite(String priorite) {
        this.priorite = priorite;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}