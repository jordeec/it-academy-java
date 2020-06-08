package itinerari.jordic.video;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VideoController implements ErrorController {

    @Autowired
    private VideoService videoService;

    @RequestMapping("/videos")
    public List<Video> getAllVideos(){
        return videoService.getAllVideos();
    }

    @RequestMapping("/videos/{id}")
    public Video getVideo(@PathVariable String id){
        return videoService.getVideo(id);
    }
    
    @RequestMapping(method = RequestMethod.POST, value="/videos")
    public void addVideo(@RequestBody Video video){
        videoService.addVideo(video);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/videos/{id}")
    public void updateVideo(@RequestBody Video video, @PathVariable String id){
        videoService.updateVideo(id, video);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/videos/{id}")
    public void deleteVideo(@PathVariable String id){
        videoService.deleteVideo(id);
    }

	@Override
	public String getErrorPath() {
		return "/error";
	}

    @RequestMapping(value = "/error")
    public String error() {
        return "Error handling";
    }



    
}