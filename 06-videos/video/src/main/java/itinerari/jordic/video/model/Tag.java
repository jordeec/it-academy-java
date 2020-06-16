package itinerari.jordic.video.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * This entity represents a tag that can be linked to any video
 * 
 * Setters and getters are omitted due to the lombok framework
 */
@Entity
public class Tag  {
    @Id
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Getter @Setter
    private String description;
    @Getter @Setter
    // Why the annotations?
    // fetch = FetchType.LAZY: We don't want the database to load all tags when instantiate a video
    // optional = true: It's possible to save a video without any tags
    // cascade = CascadeType.ALL: Whenever a tag is updated/deleted it must reflect to all the videos
    // @ManyToOne(fetch = FetchType.LAZY, optional = true, cascade = CascadeType.ALL)
    private Video video;

    public Tag() {
    }

    @Override
    public String toString() {
        return "Tag [description=" + description + ", id=" + id + ", video=" + video + "]";
    }

    

    
}