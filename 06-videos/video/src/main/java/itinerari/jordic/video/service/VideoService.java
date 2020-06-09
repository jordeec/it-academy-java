package itinerari.jordic.video.service;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

import itinerari.jordic.video.model.Video;

@Service
public class VideoService {
    List<Video> videos = Arrays.asList(
            new Video("1", "https://ftc.gov/quam/nec.jpg", "Metoprolol Succinate", "Bettie Page Reveals All"),
            new Video("2","http://ezinearticles.com/parturient/montes/nascetur/ridiculus/mus/etiam.jsp",
                    "Little Fevers Childrens Fever Pain Reliever", "In Darkness"),
            new Video("3","http://ehow.com/leo/maecenas/pulvinar/lobortis/est/phasellus/sit.js",
                    "SHISEIDO PERFECT REFINING FOUNDATION", "Lost Skeleton Returns Again"),
            new Video("4","https://photobucket.com/in.xml", "Oxygen", "Army of Darkness"),
            new Video("5","https://facebook.com/mauris/eget/massa/tempor/convallis/nulla/neque.png",
                    "POPULUS TREMULOIDES POLLEN", "Starsuckers"),
            new Video("6","https://e-recht24.de/sodales/sed/tincidunt/eu.png", "Venlafaxine Hydrochloride", "Player"),
            new Video("7","https://oaic.gov.au/nisl/duis.jpg", "Potassium Chloride", "Sun Shines Bright"),
            new Video("8","http://va.gov/massa/quis/augue/luctus.jsp", "ATORVASTATIN CALCIUM",
                    "Asterix & Obelix vs. Caesar (Astérix et Obélix contre César)"),
            new Video("9","https://nih.gov/nisl/venenatis/lacinia/aenean/sit/amet/justo.json",
                    "Coppertone TattooGuard Sunscreen", "Hotel"),
            new Video("10","http://macromedia.com/dapibus/at/diam/nam/tristique/tortor/eu.jsp", "BareMinerals",
                    "Tokyo Decadence (Topâzu)"));

    public List<Video> getAllVideos() {
        return videos;
    }

    public void addVideo(Video video) {
        videos.add(video);
    }

    public void deleteVideo(String id) {
        videos.remove(getVideo(id));
    }

    public Video getVideo(String id) {
        return videos.stream().filter(v -> v.getId().equals(id)).findFirst().get();
	}

	public void updateVideo(String id, Video video) {
	}
}