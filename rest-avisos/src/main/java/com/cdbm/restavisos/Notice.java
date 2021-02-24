package com.cdbm.restavisos;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Notice {
    private @Id @GeneratedValue Long id;
    private String title;
    private String description;
    private String createdAt;
    private String seenAt;

    public Notice(){}

    Notice(String title, String description, String createdAt, String seenAt){
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.seenAt = seenAt;
    }

    public Long getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public String getDescription(){
        return this.description;
    }

    public String getCreatedAt(){
        return this.createdAt;
    }

    public String getSeenAt(){
        return this.seenAt;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setCreatedAt(String createdAt){
        this.createdAt = createdAt;
    }

    public void setSeenAt(String seenAt){
        this.seenAt = seenAt;
    }
}
