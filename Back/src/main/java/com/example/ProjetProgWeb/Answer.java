package com.example.ProjetProgWeb;

import javax.persistence.*;
import javax.xml.soap.Text;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public Long getId() {
        return id;
    }

    @ManyToOne
    Person owner;

    public Person getOwner() {
        return owner;
    }
    public void setOwner(Person owner) {
        this.owner=owner;
    }
    @ManyToOne
    Announcement post;
    public Announcement getPost() {
        return post;
    }

    private String text;
    private Date date;

    public Answer(String text, Person owner, Announcement post){
        this.text=text;
        this.owner=owner;
        this.post=post;
        this.date=new Date(System.currentTimeMillis());
    }
     /*public Answer(String text, Professional owner, Announcement post){
        this.text=text;
        this.owner= (Person) owner;
        this.post=post;
        this.date=new Date(System.currentTimeMillis());
    }*/

    public String getText() {
        return text;
    }

    public String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat(("yyy-MM-dd 'at' HH:mm:ss z"));
        Date current=new Date(System.currentTimeMillis());
        return formatter.format(this.date);
    }
    /*
    public List<Answer> getAll(){
        List<Answer> allList=new ArrayList<>();
        return (List<Answer>) AnsRep.findAll();
    }
    */
    /*
    public void Delete(Long id){
        Repositories.AnsRep.deleteById(id);
    }
    public void Delete(Answer ans){
        Repositories.AnsRep.delete(ans);
    }
    public void Add(Answer ans){
        Repositories.AnsRep.save(ans);
    }
    public void Update(Answer ans){
        Repositories.AnsRep.save(ans);
    }
    */
}
