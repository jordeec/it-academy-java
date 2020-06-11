package itinerari.jordic.video.repository;

import org.springframework.data.repository.CrudRepository;

import itinerari.jordic.video.model.User;

public interface UserRepository extends CrudRepository<User, String> {

}