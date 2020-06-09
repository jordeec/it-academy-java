package itinerari.jordic.video.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import itinerari.jordic.video.model.UserVideo;
import itinerari.jordic.video.service.UserVideoService;

@RestController
public class UserVideoController implements ErrorController {

    @Autowired
    private UserVideoService tagService;

    @RequestMapping("/users")
    public List<UserVideo> getAllTags() {
        return tagService.getAllTags();
    }

    @RequestMapping("/users/{id}")
    public Optional<UserVideo> getUserVideo(@PathVariable String id) {
        return tagService.getUserVideo(id);
    }
    
    @RequestMapping(method = RequestMethod.POST, value="/users")
    public void addUserVideo(@RequestBody UserVideo video){
        tagService.addUserVideo(video);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
    public void updateUserVideo(@RequestBody UserVideo video, @PathVariable String id){
        tagService.updateUserVideo(id, video);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
    public void deleteUserVideo(@PathVariable String id){
        tagService.deleteUserVideo(id);
    }

	@Override
	public String getErrorPath() {
		return "/error";
	}


    
}