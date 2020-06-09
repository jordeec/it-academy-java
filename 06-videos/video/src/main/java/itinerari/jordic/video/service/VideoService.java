package itinerari.jordic.video.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import itinerari.jordic.video.model.Video;
import itinerari.jordic.video.repository.VideoRepository;

@Service
public class VideoService {

        @Autowired
        private VideoRepository videoRepository;
/*
        private List<Video> videos = new ArrayList<Video>(Arrays.asList(
                        new Video("1", "https://ftc.gov/quam/nec.jpg", "Metoprolol Succinate",
                                        "Bettie Page Reveals All"),
                        new Video("2", "http://ezinearticles.com/parturient/montes/nascetur/ridiculus/mus/etiam.jsp",
                                        "Little Fevers Childrens Fever Pain Reliever", "In Darkness"),
                        new Video("3", "http://ehow.com/leo/maecenas/pulvinar/lobortis/est/phasellus/sit.js",
                                        "SHISEIDO PERFECT REFINING FOUNDATION", "Lost Skeleton Returns Again"),
                        new Video("4", "https://photobucket.com/in.xml", "Oxygen", "Army of Darkness"),
                        new Video("5", "https://facebook.com/mauris/eget/massa/tempor/convallis/nulla/neque.png",
                                        "POPULUS TREMULOIDES POLLEN", "Starsuckers"),
                        new Video("6", "https://e-recht24.de/sodales/sed/tincidunt/eu.png", "Venlafaxine Hydrochloride",
                                        "Player"),
                        new Video("7", "https://oaic.gov.au/nisl/duis.jpg", "Potassium Chloride", "Sun Shines Bright"),
                        new Video("8", "http://va.gov/massa/quis/augue/luctus.jsp", "ATORVASTATIN CALCIUM",
                                        "Asterix & Obelix vs. Caesar (Astérix et Obélix contre César)"),
                        new Video("9", "https://nih.gov/nisl/venenatis/lacinia/aenean/sit/amet/justo.json",
                                        "Coppertone TattooGuard Sunscreen", "Hotel"),
                        new Video("10", "http://macromedia.com/dapibus/at/diam/nam/tristique/tortor/eu.jsp",
                                        "BareMinerals", "Tokyo Decadence (Topâzu)")));
/*

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
}