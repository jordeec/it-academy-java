package itinerari.jordic.video.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class User implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 5444434728847905474L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter    
    private Long id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String surname;
    @Getter @Setter
    private Date regDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @Getter @Setter
    @JsonIgnore
    private Collection <Video> videos = new ArrayList<Video>();

    /** Constructors */

    public User(){
        super();
        // Since this is a registration date it won't be modified and it'll be set on the very
        // first instation of the object
        this.regDate = new Date(System.currentTimeMillis());
    }

    public User(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    /** Overrides  */

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", regDate=" + regDate + ", surname=" + surname + ", videos="
                + videos.size() + "]";
    }

    
    
}