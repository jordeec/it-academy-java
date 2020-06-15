package itinerari.jordic.video.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import itinerari.jordic.video.model.Tag;
import itinerari.jordic.video.repository.TagRepository;

@Service
public class TagService {

        @Autowired
        private TagRepository tagRepository;

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

        public void addTag(Tag tag, String userId, String videoId) {
                tagRepository.save(tag);
        }

        public void deleteTag(String id) {
                tagRepository.deleteById(id);
        }

        public Optional<Tag> getTag(String id) {
                return tagRepository.findById(id);
        }

        public void updateTag(String id, Tag tag) {
                tagRepository.save(tag);
        }


}