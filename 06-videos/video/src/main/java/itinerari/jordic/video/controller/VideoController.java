package itinerari.jordic.video.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import itinerari.jordic.video.model.Video;
import itinerari.jordic.video.service.VideoService;

@RestController
public class VideoController implements ErrorController {

    @Autowired
    private VideoService videoService;

    @GetMapping("/users/{id}/videos")
    public List<Video> getAllVideosByUserId(@PathVariable Long id) {
        return videoService.getVideosByUserId(id);
    }

    @GetMapping("/videos")
    public List<Video> getAllVideos() {
        return videoService.getAllVideos();
    }

    @GetMapping("/users/{idUser}/videos/{idVideo}")
    public Optional<Video> getVideo(@PathVariable Long idUser, @PathVariable Long idVideo) {
        return videoService.getVideoByUserId(idUser, idVideo);
    }
    
    @RequestMapping(method = RequestMethod.POST, value="/users/{id}/videos")
    public void addVideo(@RequestBody Video video, @PathVariable Long id) {
        videoService.addVideo(video, id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/videos/{id}")
    public void updateVideo(@RequestBody Video video, @PathVariable String id){
        videoService.updateVideo(id, video);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/videos/{id}")
    public void deleteVideo(@PathVariable Long id) {
        videoService.deleteVideo(id);
    }

    @Override
    public String getErrorPath() {
        return null;
    }

    
}