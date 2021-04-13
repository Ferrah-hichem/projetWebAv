package com.example.ProjetProgWeb;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;


@Component
public class DataInitializer implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(DataInitializer.class);

    public static List<Person> users= new ArrayList<Person>();
    public static List<Professional> pros= new ArrayList<Professional>();
    public static List<Announcement> posts = new ArrayList<Announcement>();
    public static List<Answer> Answers = new ArrayList<Answer>();
    //public ProfessionalRepository ProReps;
    //List<Answer> answers = new ArrayList<Answer>();

    @Autowired
    private AnnounceRepository PostRep;
    @Autowired
    private AnswerRepository AnsRep;
    @Autowired
    private PersonRepository PersRep;
    @Autowired
    private ProfessionalRepository ProRep;

    @Override
    public void run(String... args) throws Exception {
        // Buffer Variables
        Person client;
        Professional pro;
        Announcement post;
        Answer answer;

        //Initialize table Professional
        pro = new Professional("Hitch",
                "Ferrah Hichem",
                "Paris",
                new String[]{"Prog Web","java Spring","3D art"},
                "ferrah.hichem@gmail.com",
                "Etudiant M1 MLDS Univ. Paris",
                false,
                "www.Artstation.com/hi-t-ch");
        ProRep.save(pro);
        pros.add(pro);

        pro = new Professional("Head Master",
                "Steely Dan",
                "New York",
                new String[]{"Music","jazz","Pop","70s"},
                "Aja@Bodhisattva.com",
                "Walter Baker & Donald Fagen",
                false,
                "www.SteelyDan.com");
        ProRep.save(pro);
        pros.add(pro);

        pro = new Professional("Google",
                "Google FR",
                "Paris",
                new String[]{"Computer Science","Internet","Business"},
                "google@gmail.com",
                "Google france",
                true,
                "www.google.com/fr/");

        ProRep.save(pro);
        pros.add(pro);

        //Initialize table Person (clients not pros)
        client = new Person("Client00",
                "Abstract Name",
                "Paris",
                new String[]{"Travail","programmation","Computer Science","Web"},
                "AbNa@gmail.com",
                "Diplomé à la recherche d'un travail"
        );
        PersRep.save(client);
        users.add(client);

        client = new Person("MuffinMan",
                "Zappa",
                "New York",
                new String[]{"Music","jazz","fusion"},
                "zappa@MuffinFactory.com",
                "Searching for Musicians"
        );
        PersRep.save(client);
        users.add(client);

        //Initialize table Announcement (clients not pros)
        post = new Announcement("1st Post",
                new String[]{"test","1st","abstract"},
                "1ere Annonce Bienvenue à tous le monde, svp invitez vos Amis et partagez ce site autour de vous"
        );
        post.setOwner(pros.get(0));
        PostRep.save(post);
        posts.add(post);

        post = new Announcement("Job Offers",
                new String[]{"Google","Big DATA","internet","Data"},
                "We are looking for a new Data scientist, Master Degree or Above Required. FR: Google FR est à la recherche d'un Data Scientist, Diplome Master est requit."
        );
        post.setOwner(pros.get(2));
        posts.add(post);
        PostRep.save(post);

        post = new Announcement("Internship Offers",
                new String[]{"Google","Big DATA","internet","Data","Computer Science"},
                "If you are looking for an internship at Google FR, contact us at google@gmail.com"
        );
        post.setOwner(pros.get(2));
        posts.add(post);
        PostRep.save(post);

        //Initialize table Answers
        answer = new Answer("1st test answer",
                pros.get(0),
                posts.get(0)
        );
        Answers.add(answer);
        AnsRep.save(answer);

        answer = new Answer("it works (y)",
                users.get(0),
                posts.get(0)
        );
        Answers.add(answer);
        AnsRep.save(answer);

        answer = new Answer("interested, please check yout inbox",
                users.get(0),
                posts.get(2)
        );
        Answers.add(answer);
        AnsRep.save(answer);
    }

}
