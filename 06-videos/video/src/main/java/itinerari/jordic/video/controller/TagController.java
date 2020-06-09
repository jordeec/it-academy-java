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

import itinerari.jordic.video.model.Tag;
import itinerari.jordic.video.service.TagService;

@RestController
public class TagController implements ErrorController {

    @Autowired
    private TagService tagService;

    @RequestMapping("/tags")
    public List<Tag> getAllTags() {
        return tagService.getAllTags();
    }

    @RequestMapping("/tags/{id}")
    public Optional<Tag> getVideo(@PathVariable String id) {
        return tagService.getTag(id);
    }
    
    @RequestMapping(method = RequestMethod.POST, value="/tags")
    public void addTag(@RequestBody Tag video){
        tagService.addTag(video);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/tags/{id}")
    public void updateTag(@RequestBody Tag video, @PathVariable String id){
        tagService.updateTag(id, video);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/tags/{id}")
    public void deleteTag(@PathVariable String id){
        tagService.deleteTag(id);
    }

	@Override
	public String getErrorPath() {
		return "/error";
	}

}