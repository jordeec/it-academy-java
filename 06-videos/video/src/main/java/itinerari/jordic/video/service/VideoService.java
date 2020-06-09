package itinerari.jordic.video.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import itinerari.jordic.video.model.UserVideo;
import itinerari.jordic.video.model.Video;
import itinerari.jordic.video.repository.VideoRepository;

@Service
public class VideoService {

        @Autowired
        private VideoRepository videoRepository;

        /**
         * Calls JPA Repository and for each element in the table Videos it fills an
         * element in the videos array List
         * 
         * @return
         */
        public List<Video> getAllVideos() {
                List<Video> videos = new ArrayList<Video>();
                videoRepository.findAll().forEach(videos::add);

                return videos;
        }

        public void addVideo(Video video) {
                video.setUserVideo(new UserVideo());
                videoRepository.save(video);
        }

        public void deleteVideo(String id) {
                videoRepository.deleteById(id);
        }

        public Optional<Video> getVideo(String id) {
                return videoRepository.findById(id);
        }

        public void updateVideo(String id, Video video) {
                videoRepository.save(video);
        }

        public List<Video> getVideosByUserVideoId(String userid){
                List<Video> videos = new ArrayList<Video>();
                videoRepository.findByUserVideo(userid).forEach(videos::add);

                return videos;
        }


}