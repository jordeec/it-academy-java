package itinerari.jordic.video.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * This entity represents a tag that can be linked to any video
 * 
 * Setters and getters are omitted due to the lombok framework
 */
@Entity
public class Tag implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -6615763655000703399L;
    
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Getter
    @Setter
    private String description;
    // Why the annotations?
    // fetch = FetchType.LAZY: We don't want the database to load all tags when
    // instantiate a video
    // optional = true: It's possible to save a video without any tags
    // cascade = CascadeType.ALL: Whenever a tag is updated/deleted it must reflect
    // to all the videos
    // @ManyToOne(fetch = FetchType.LAZY, optional = true, cascade =
    // CascadeType.ALL)

    // each tag is linked to a specific video
    @ManyToOne(fetch = FetchType.LAZY, optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "video_id")
    @Getter
    @Setter
    private Video video;

    /** Constructors */

    public Tag() {
    }

    public Tag(String tag){
        this.description = tag;
    }

    /** Overrides */

    @Override
    public String toString() {
        return "Tag [description=" + description + ", id=" + id + ", video=" + video + "]";
    }
}