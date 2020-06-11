package itinerari.jordic.video.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import itinerari.jordic.video.model.Video;
import itinerari.jordic.video.repository.UserRepository;
import itinerari.jordic.video.repository.VideoRepository;

@Service
public class VideoService {

        @Autowired
        private VideoRepository videoRepository;
        @Autowired
        private UserRepository userRepository; // TODO: (Jose) com ens podem desvincular del usuari en el video?

        /**
         * Calls JPA Repository and for each element in the table Videos it fills an
         * element in the videos array List
         * 
         * @return
         */
        public List<Video> getAllVideos() {
                final List<Video> videos = new ArrayList<Video>();
                videoRepository.findAll().forEach(videos::add);

                return videos;
        }

        /**
         * Uses lambda expression to get first the user from the video and after it
         * saves the video to the repository
         * 
         * @param video  Video to be saved
         * @param userId User's identifier
         */
        public void addVideo(final Video video, final String userId) {
/*
                return userVideoRepository.findById(userId).map(user -> {
                        // For each user found in the user repository ...
                        video.setUserVideo(user);
                        videoRepository.save(video);
                }).orElseThrow(() -> new ResourceNotFoundException()); // If the user is not found we throw an exception
*/
        }

        public void deleteVideo(final String id) {
                videoRepository.deleteById(id);
        }

        public Optional<Video> getVideo(final String id) {
                return videoRepository.findById(id);
        }

        public void updateVideo(final String id, final Video video) {
                videoRepository.save(video);
        }

        public List<Video> getVideosByUserVideoId(final String userid) {
                final List<Video> videos = new ArrayList<Video>();
                videoRepository.findByUserVideo(userid).forEach(videos::add);

                return videos;
        }

}