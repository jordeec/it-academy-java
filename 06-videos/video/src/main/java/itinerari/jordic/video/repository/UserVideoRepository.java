package itinerari.jordic.video.repository;

import org.springframework.data.repository.CrudRepository;

import itinerari.jordic.video.model.UserVideo;

public interface UserVideoRepository extends CrudRepository<UserVideo, String> {

}