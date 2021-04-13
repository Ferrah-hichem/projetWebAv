package com.example.ProjetProgWeb;

public class Repositories {
    private AnnounceRepository PostRep;
    private AnswerRepository AnsRep;
    private PersonRepository PersRep;
    private ProfessionalRepository ProRep;

    public PersonRepository getPersRep() { return PersRep;}
    public AnswerRepository getAnsRep() { return AnsRep;}
    public AnnounceRepository getPostRep() { return PostRep; }
    public ProfessionalRepository getProRep() { return ProRep; }

    public void add(Person E){this.PersRep.save(E);}
    public void add(Professional E){this.ProRep.save(E);}
    public void add(Announcement E){this.PostRep.save(E);}
    public void add(Answer E){this.AnsRep.save(E);}

}
