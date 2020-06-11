package itinerari.jordic.video.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Entity to represent the users in our video application, the class is named UserVideo to avoid
 * conflicts with the database
 * 
 * Setters and getters are omitted due to the lombok framework
 *  
 */

@Entity
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

    @OneToMany(mappedBy = "videos")
    private Set<Video> videos;

    public User(){
        super();
    }

    public User(String id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        // Since this is a registration date it won't be modified and it'll be set on the very
        // first instation of the object
        this.regDate = new Date(System.currentTimeMillis());
    }

    

    
}