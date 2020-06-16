package itinerari.jordic.video.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import itinerari.jordic.video.exception.UserNotFoundException;
import itinerari.jordic.video.exception.VideoNotFoundException;
import itinerari.jordic.video.model.User;
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
         * saves the video to the repository
         * 
         * @param video  Video to be saved
         * @param userId User's identifier
         */
        public void addVideo(final Video video, final Long userId) {

                Optional<User> user = userRepository.findById(userId);

                if (user.isPresent()) {
                        //FIXME: Es crea una dependencia infinita!!
                        video.setUser(user.get());
                        videoRepository.save(video);
                        userRepository.save(user.get());
                }
        }

        public void deleteVideo(final Long id) {
                videoRepository.deleteById(id);
        }

        public Optional<Video> getVideo(final Long id) {
                return videoRepository.findById(id);
        }

        public void updateVideo(final String id, final Video video) {
                videoRepository.save(video);
        }

        public List<Video> getVideosByUserId(final Long userid) {
                return videoRepository.findByUserId(userid);
        }

        public Optional<Video> getVideoByUserId(Long idUser, Long idVideo) {
                Optional<User> user = userRepository.findById(idUser);
                Optional<Video> video;

                if (user.isPresent()) {
                        video = videoRepository.findById(idVideo);

                        if (video.isPresent()) {
                                return video;
                        } else {
                                throw new VideoNotFoundException(String.format(
                                                "Video with id %s is not found for userId %s", idVideo, idUser));
                        }
                } else {
                        throw new UserNotFoundException(String.format("User is not found with userId %s", idUser));
                }
        }

}