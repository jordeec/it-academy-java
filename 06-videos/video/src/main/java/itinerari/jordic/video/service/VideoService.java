package itinerari.jordic.video.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import itinerari.jordic.video.exception.UserNotFoundException;
import itinerari.jordic.video.exception.VideoNotFoundException;
import itinerari.jordic.video.exception.VideoRESTAppException;
import itinerari.jordic.video.model.User;
import itinerari.jordic.video.model.Video;
import itinerari.jordic.video.repository.UserRepository;
import itinerari.jordic.video.repository.VideoRepository;

@Service
public class VideoService {

	@Autowired
	private VideoRepository videoRepository;
	@Autowired
	private UserRepository userRepository; // TODO: (Jose) com ens podem desvincular del usuari en el video?

	/**
	 * Calls JPA Repository and for each element in the table Videos it fills an
	 * element in the videos array List
	 * 
	 * @return
	 */
	public List<Video> getAllVideos() {
		final List<Video> videos = new ArrayList<Video>();
		videoRepository.findAll().forEach(videos::add);

		return videos;
	}

	/**
	 * saves the video to the repository
	 * 
	 * @param video  Video to be saved
	 * @param userId User's identifier
	 */
	public void addVideo(final Video video, final Long userId) {

		Optional<User> user = userRepository.findById(userId);

		if (user.isPresent()) {
			video.setUser(user.get());
			videoRepository.save(video);
			userRepository.save(user.get());
		}
	}

	public void deleteVideo(final Long id) {
		videoRepository.deleteById(id);
	}

	public Optional<Video> getVideo(final Long id) {
		return videoRepository.findById(id);
	}

	public Video updateVideo(final Long id, final Video video) {

		Optional<Video> v = videoRepository.findById(id);

		if (!v.isPresent()) {
			throw new VideoNotFoundException(String.format("Video %s is not found", video));
		}

		return videoRepository.save(video);
	}

	public List<Video> getVideosByUserId(final Long userid) {
		return videoRepository.findByUserId(userid);
	}

	public Optional<Video> getVideoByUserId(Long idUser, Long idVideo) {
		Optional<User> user = userRepository.findById(idUser);
		Optional<Video> video = videoRepository.findById(idVideo);

		// Modified method with guard clause
		if (!user.isPresent()) {
			throw new UserNotFoundException(String.format("User is not found with userId %s", idUser));
		}

		if (!video.isPresent()) {
			throw new VideoNotFoundException(
					String.format("Video with id %s is not found for userId %s", idVideo, idUser));
		}

		return video;
	}

	public Video updateVideo(Long idUser, Long idVideo, Video video) {
		Video v;

		try {
			v = getVideoByUserId(idUser, idVideo).get();
		} catch (VideoRESTAppException e) {
			throw e;
		}

		/**
		 * Only a few properties are updateable 
		 * 
		 */
		v.setName(video.getName());
		v.setTitle(video.getTitle());
		v.setUrl(video.getUrl());

		return videoRepository.save(v);
	}
	
}