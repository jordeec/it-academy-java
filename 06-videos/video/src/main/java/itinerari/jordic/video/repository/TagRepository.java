package itinerari.jordic.video.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import itinerari.jordic.video.model.Tag;

public interface TagRepository extends CrudRepository<Tag, String> {

    public List<Tag> findByDescription(String description);

    public List<Tag> findByVideo(String idVideo);

    
}