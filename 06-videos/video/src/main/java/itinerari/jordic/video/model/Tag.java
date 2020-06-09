package itinerari.jordic.video.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * This entity represents a tag that can be linked to any video
 * 
 * Setters and getters are omitted due to the lombok framework
 */
@Entity
public class Tag {
    @Id
    @Getter @Setter
    private String id;
    @Getter @Setter
    private String description;
    @ManyToOne
    @Getter @Setter
    private Video video;

}