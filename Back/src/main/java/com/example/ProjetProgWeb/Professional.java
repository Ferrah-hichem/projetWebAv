package com.example.ProjetProgWeb;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Professional extends Person {


    private boolean businessOrg;
    private String website;
    /*
    private Collection<Announcement> announcements;
    @OneToMany(cascade= CascadeType.ALL, mappedBy="Professional")
    public Collection<Announcement> getAnnouncements() {
        return announcements;
    }
    */
    public Professional(){
        super();
    }
    public Professional(String username, String fullName, String ville, String[] tags, String email, String description, boolean businessOrg, String website) {
        super(username, fullName, ville, tags, email, description);
        this.businessOrg=businessOrg;
        this.website = website;
    }

    public void setBusinessOrg(boolean businessOrg) {
        if (businessOrg) this.businessOrg = true;
        else this.businessOrg = false;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getWebsite() {
        return website;
    }
    /*
    public Iterable<ProfessionalRepository> getAllP(){
        Iterable<ProfessionalRepository> all = Repositories.ProRep.findAll();
        return all;
    }

    public ProfessionalRepository getProRep() {
        return Repositories.ProRep;
    }

     */

}
