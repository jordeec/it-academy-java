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

import itinerari.jordic.video.model.User;
import itinerari.jordic.video.service.UserService;

@RestController
public class UserController implements ErrorController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping("/users/{id}")
    public Optional<User> getUserVideo(@PathVariable String id) {
        return userService.getUserVideo(id);
    }
    
    @RequestMapping(method = RequestMethod.POST, value="/users")
    public void addUserVideo(@RequestBody User video){
        userService.addUserVideo(video);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
    public void updateUserVideo(@RequestBody User video, @PathVariable String id){
        userService.updateUserVideo(id, video);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
    public void deleteUserVideo(@PathVariable String id){
        userService.deleteUserVideo(id);
    }

	@Override
	public String getErrorPath() {
		return "/error";
	}


    
}