package itinerari.jordic.video.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import itinerari.jordic.video.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {

    public List<Tag> findByDescription(String description);

    public List<Tag> findByVideo(Long idVideo);
    
}