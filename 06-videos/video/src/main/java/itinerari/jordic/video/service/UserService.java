package itinerari.jordic.video.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import itinerari.jordic.video.exception.UserNotFoundException;
import itinerari.jordic.video.model.User;
import itinerari.jordic.video.repository.UserRepository;


/**
 * This services only forwards the objects to the repository layer where it will
 * be saved according to the Database Dialect / JPA Source
 * 
 */

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * Calls JPA Repository and for each element in the table UserVideo it fills an
	 * element in the users array List
	 * 
	 * @return
	 */
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		userRepository.findAll().forEach(users::add);

		return users;
	}

	public void addUser(User user) {
		userRepository.save(user);
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	public Optional<User> getUser(Long id) {
		return userRepository.findById(id);
	}

	public User updateUser(Long id, User user) {
		Optional<User> u = userRepository.findById(id);

		if(!u.isPresent()){
			throw new UserNotFoundException(String.format("User with ID %s not found in database", id));
		}else {
			/**
			 * We are only saving two properties since the other two are read only
			 * 
			 */
			u.get().setName(user.getName());
			u.get().setSurname(user.getSurname());
			return userRepository.save(u.get());
		}
	}
}