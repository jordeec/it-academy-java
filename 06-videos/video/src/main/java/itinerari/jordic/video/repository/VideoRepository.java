package itinerari.jordic.video.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import itinerari.jordic.video.model.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {

	List<Video> findByUserId(Long userid);
    
    
}