package itinerari.jordic.video.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import itinerari.jordic.video.model.UserVideo;
import itinerari.jordic.video.repository.UserVideoRepository;


@Service
public class UserVideoService {

        @Autowired
        private UserVideoRepository userVideoRepository;

        /**
         * Calls JPA Repository and for each element in the table UserVideo it fills an
         * element in the users array List
         * 
         * @return
         */
        public List<UserVideo> getAllTags() {
                List<UserVideo> users = new ArrayList<UserVideo>();
                userVideoRepository.findAll().forEach(users::add);

                return users;
        }

        public void addUserVideo(UserVideo user) {
                userVideoRepository.save(user);
        }

        public void deleteUserVideo(String id) {
                userVideoRepository.deleteById(id);
        }

        public Optional<UserVideo> getUserVideo(String id) {
                return userVideoRepository.findById(id);
        }

        public void updateUserVideo(String id, UserVideo tag) {
                userVideoRepository.save(tag);
        }
}