package itinerari.jordic.video.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import itinerari.jordic.video.exception.TagNotFoundException;
import itinerari.jordic.video.exception.UserNotFoundException;
import itinerari.jordic.video.exception.VideoNotFoundException;
import itinerari.jordic.video.exception.VideoRESTAppException;
import itinerari.jordic.video.model.Tag;
import itinerari.jordic.video.model.User;
import itinerari.jordic.video.model.Video;
import itinerari.jordic.video.repository.TagRepository;
import itinerari.jordic.video.repository.UserRepository;
import itinerari.jordic.video.repository.VideoRepository;

@Service
public class TagService {

	@Autowired
	private TagRepository tagRepository;
	@Autowired
	private VideoRepository videoRepository;
	@Autowired
	private UserRepository userRepository;

	/**
	 * Calls JPA Repository and for each element in the table Tags it fills an
	 * element in the tags array List
	 * 
	 * @return
	 */
	public List<Tag> getAllTags() {
		List<Tag> tags = new ArrayList<Tag>();
		
		tagRepository.findAll().forEach(tags::add);

		return tags;
	}

	public void deleteTag(Long id) {
		tagRepository.deleteById(id);
	}

	public Optional<Tag> getTag(Long id) {
		return tagRepository.findById(id);
	}

	public void updateTag(Long tagId, Tag tag) {
		Optional<Tag> t = tagRepository.findById(tagId);
		if(!t.isPresent()){
			throw new TagNotFoundException(String.format("Tag %s is not found in database", tagId));
		}

		// Only the description is allowed to be changed
		t.get().setDescription(tag.getDescription());
		tagRepository.save(t.get());
	}

	public List<Tag> getAllTagsByVideo(Long videoId) {
		Optional<Video> v = videoRepository.findById(videoId);

		if (!v.isPresent()) {
			throw new VideoNotFoundException(String.format("Video %s can't be found", videoId));
		}

		return tagRepository.findByVideo(v.get());

	}

	public List<Tag> getAllTagsByUserByVideo(Long userId, Long videoId) {
		Optional<User> u = userRepository.findById(userId);
		Optional<Video> v = videoRepository.findById(videoId);

		if (!u.isPresent())
			throw new UserNotFoundException(String.format("User %s can't be found", userId));
		if (!v.isPresent())
			throw new VideoNotFoundException(String.format("Video %s can't be found", videoId));
		
		return tagRepository.findByVideo(v.get());

	}

	/**
	 * Saves a new tag in database. We must refer to a specific video and user in order to do so
	 * 
	 * @param tag Tag object from the client
	 * @param userId User identifier
	 * @param videoId Video identifier
	 * 
	 * @return created tag object
	 */
	public Tag addTag(Tag tag, Long userId, Long videoId) {
		List<Tag> tags;
		Video v;
		try {
			v = videoRepository.findById(videoId).get();
			tags = getAllTagsByUserByVideo(userId, videoId);	
		} catch (VideoRESTAppException e) {
			throw e;
		}
		Tag t = new Tag(tag.getDescription());
		t.setVideo(v);
		tagRepository.save(t);
		tags.add(t);
 
		return t;
	}

}
