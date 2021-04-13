package com.example.ProjetProgWeb;

import javax.persistence.*;
import java.util.*;

@Entity
public class Person {

    @Id
    private String username;
    private String fullName;
    private String location;
    private String[] tags; // Aide à l'indexation ~~~~ centre d'interets
    private String email;
    private String description;

    /*private Collection<Answer> answers;
    @OneToMany(cascade= CascadeType.ALL, mappedBy="Person", targetEntity = Answer.class)
    public Collection<Answer> getAnswers() {
        return answers;
    }*/

    public Person(String username, String fullName, String location, String[] tags, String email,String description) {
        this.username = username;
        this.fullName = fullName;
        this.location = location;
        this.tags = tags;
        this.email= email;
        this.description=description;
    }

    public Person() {

    }

    //le reste des Setters et Getters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setTags(String[] Tags) {
        tags = Tags;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getTags() {
        return tags;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return fullName;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    /*public List<Person> getAll(){
        List<Person> allList=new ArrayList<>();
        return (List<Person>) Repositories.PersRep.findAll();
    }

    //Mises à jour de la BD
    public void Delete(String user){
        Repositories.PersRep.deleteById(user);
    }
    public void Delete(Person pro){
        Repositories.PersRep.delete(pro);
    }
    public void Add(Person pro){
        Repositories.PersRep.save(pro);
    }
    public void Update(Person pro){ Repositories.PersRep.save(pro); }
    */

    /*public Person find(String username){
        List<Optional> list= new ArrayList<>();
        list.add(PersRep.findById(username) );
        Person person = (Person) list.get(0);
        return person;
    }*/
}
