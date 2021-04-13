package com.example.ProjetProgWeb;

import javafx.geometry.Pos;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.io.Serializable;
import java.util.List;

@Entity
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public Long getId() {
        return id;
    }

    private String title;
    private String[] tags; // Aide à l'indexation
    private String description;
    private Date date;

    @ManyToOne
    Professional owner;
    public Professional getOwner() {
        return owner;
    }
    public void setOwner(Professional owner) {
        this.owner = owner;
    }

    /*
    private Collection<Answer> answers;
    @OneToMany(cascade= CascadeType.ALL, mappedBy="Announcement")
    public Collection<Answer> getAnswers() {
        return answers;
    }
    */
  
    public Announcement(String title, String[] Tags, String Description){
        this.title=title;
        this.tags=Tags;
        this.description=Description;
        this.date=new Date(System.currentTimeMillis());
    }
    public Announcement(String title, String[] Tags, String Description, Professional owner){
        this.title=title;
        this.tags=Tags;
        this.description=Description;
        this.owner=owner;
        this.date=new Date(System.currentTimeMillis());
    }
    public Announcement(){

    }
    public Announcement(Announcement A){
        this.title=A.title;
        this.owner=A.owner;
        this.tags=A.tags;
        this.description=A.description;
        this.date=new Date(System.currentTimeMillis());
    }
    public void setTitle(String title) {
        title = title;
    }
    public void setDateNow(){
        this.date=new Date(System.currentTimeMillis());
    }
    public void setDescription(String description) {
        description = description;
    }

    public void setTags(String[] tags) {
        tags = tags;
    }


    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public String[] getTags() {
        return tags;
    }

    public String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat(("yyy-MM-dd 'at' HH:mm:ss z"));
        Date current=new Date(System.currentTimeMillis());
        return formatter.format(this.date);
    }
    public void setDate(Date date){
        this.date=date;
    } 
    /*
    public List<Announcement> getAll(){
        List<Announcement> allList=new ArrayList<>();
        return (List<Announcement>) Repositories.PostRep.findAll();
    }
    public void Delete(Long id){
        Repositories.PostRep.deleteById(id);
    }
    public void Delete(Announcement post){
        Repositories.PostRep.delete(post);
    }
    public void Add(Announcement post){
        Repositories.PostRep.save(post);
    }
    public void Update(Announcement post){
        Repositories.PostRep.save(post);
    }
    */
}
