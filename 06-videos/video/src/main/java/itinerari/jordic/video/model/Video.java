package itinerari.jordic.video.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.jmx.export.annotation.ManagedResource;

import lombok.Getter;
import lombok.Setter;

/**
 * Entity class to represent a Video in our application
 * 
 * Setters and getters are omitted due to the lombok framework
 */
@Entity
public class Video implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 8576371405306112071L;
    @Id
    @Getter @Setter
    private String id;
    @Getter @Setter
    private String url;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String title;
    
    // Each video is linked to a specific user
    @Getter @Setter
    private User user;

    // Each video contains a list of tags
    @Getter @Setter
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "video", nullable = true)
    private Collection<Tag> tags = new ArrayList<Tag>();
    

    // This annotation provides the default values for this entity
    @PersistenceConstructor
    public Video(String id, String url, String name, String title){
        super();
        this.id = id;
        this.url = url;
        this.name = name;
        this.title = title;

    }

    public Video() {
    }
    
}