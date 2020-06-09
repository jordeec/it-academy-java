package itinerari.jordic.video.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import itinerari.jordic.video.model.Video;

public interface VideoRepository extends CrudRepository<Video, String> {
    
    public List<Video> findByUserVideo(String userid);
    
}