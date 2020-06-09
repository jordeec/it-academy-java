package itinerari.jordic.video.repository;

import org.springframework.data.repository.CrudRepository;

import itinerari.jordic.video.model.Video;

public interface VideoRepository extends CrudRepository<Video, String> {
    
    
}