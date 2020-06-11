package itinerari.jordic.video.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * Entity class to represent a Video in our application
 * 
 * Setters and getters are omitted due to the lombok framework
 */
@Entity
public class Video {

    @Id
    @Getter @Setter
    private String id;
    @Getter @Setter
    private String url;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String title;
    
    // Every video 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, unique = true)
    @Getter @Setter
    private User user;

    public Video(){
        super();
    }

    public Video(String id, String url, String name, String title){
        super();
        this.id = id;
        this.url = url;
        this.name = name;
        this.title = title;
    }
    
}