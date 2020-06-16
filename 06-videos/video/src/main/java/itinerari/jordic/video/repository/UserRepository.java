package itinerari.jordic.video.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import itinerari.jordic.video.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}