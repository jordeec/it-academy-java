package itinerari.jordic.video.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

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
public class UserVideo {
    @Id
    @Getter @Setter    
    private String id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String surname;
    @Getter @Setter
    private Date regDate;

    public UserVideo(){
        super();
    }

    public UserVideo(String id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        // Since this is a registration date it won't be modified and it'll be set on the very
        // first instation of the object
        this.regDate = new Date(System.currentTimeMillis());
    }

    

    
}