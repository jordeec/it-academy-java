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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import itinerari.jordic.video.model.Tag;
import itinerari.jordic.video.service.TagService;

@RestController
public class TagController implements ErrorController {

    @Autowired
    private TagService tagService;

    @GetMapping("/tags")
    public List<Tag> getAllTags() {
        return tagService.getAllTags();
    }

    @GetMapping("/tags/{id}")
    public Optional<Tag> getTag(@PathVariable String id) {
        return tagService.getTag(id);
    }

    /**
     In order to save a Tag in database we must refer to the video it belongs to, hence we must provide
     also the corresponding user since according to the model, every video must belong to a single user.
     Nonetheless, we can save a video without tags or we can assign the same tag to several videos

     * @param video
     * @param userId
     * @param videoId
     */
    @RequestMapping(method = RequestMethod.POST, value="users/{userId}/videos/{videoId}/tags")
    public void addTag(@RequestBody Tag video, @RequestParam String userId, @RequestParam String videoId){
        tagService.addTag(video, userId, videoId);
    }

    /**
     * We allow the modification of a tag directly from the request
     * 
     * @param tag
     * @param id
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/tags/{id}")
    public void updateTag(@RequestBody Tag tag, @PathVariable String id){
        tagService.updateTag(id, tag);
    }

    /**
     * We allow deleting a given tag from the request
     * 
     * @param id
     */

    @RequestMapping(method = RequestMethod.DELETE, value = "/tags/{id}")
    public void deleteTag(@PathVariable String id){
        tagService.deleteTag(id);
    }

	@Override
	public String getErrorPath() {
		return "/error";
	}

}