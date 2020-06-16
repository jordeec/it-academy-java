package itinerari.jordic.video.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

// import org.springframework.data.annotation.PersistenceConstructor;

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
    private static final long serialVersionUID = -2246078850526704729L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String url;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String title;

    // each video is linked to a specific user
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @Getter @Setter
    private User user;

    // Each video contains a list of tags
    @Getter @Setter
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "video", nullable = true)
    private Collection<Tag> tags = new ArrayList<Tag>();
    
    public Video(Long id, String url, String name, String title){
        this.id = id;
        this.url = url;
        this.name = name;
        this.title = title;

    }

    public Video() {
    }

    @Override
    public String toString() {
        return "Video [id=" + id + ", name=" + name + ", tags=" + tags + ", title=" + title + ", url=" + url + "]";

    }
    
}