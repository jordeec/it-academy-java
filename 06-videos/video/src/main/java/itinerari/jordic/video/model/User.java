package itinerari.jordic.video.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Entity to represent the users in our video application
 * 
 * Setters and getters are omitted due to the lombok framework
 *  
 */

@Entity
// We use the table annotation to avoid conflicts in the database where USER is very likely a reserved word
@Table(name = "USERVIDEO")
public class User {
    @Id
    @Getter @Setter    
    private String id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String surname;
    @Getter @Setter
    private Date regDate;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @Getter @Setter
    private Collection <Video> video = new ArrayList<Video>();

    public User(){
        super();
        // Since this is a registration date it won't be modified and it'll be set on the very
        // first instation of the object
        this.regDate = new Date(System.currentTimeMillis());
    }

    public User(String id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }
    
}