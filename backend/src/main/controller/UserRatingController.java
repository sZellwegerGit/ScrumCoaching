package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userratings")
public class UserRatingController {

    @Autowired
    private UserRatingRepository userRatingRepository;

    @GetMapping("/{id}")
    public ResponseEntity<UserRating> getUserRatingById(@PathVariable int id) {
        UserRating userRating = userRatingRepository.findById(id).orElse(null);
        if (userRating == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userRating, HttpStatus.OK);
    }

    @GetMapping
    public List<UserRating> getAllUserRatings() {
        return userRatingRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<UserRating> createUserRating(@RequestBody UserRating userRating) {
        userRatingRepository.save(userRating);
        return new ResponseEntity<>(userRating, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserRating> updateUserRating(@PathVariable int id, @RequestBody UserRating userRating) {
        UserRating existingUserRating = userRatingRepository.findById(id).orElse(null);
        if (existingUserRating == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingUserRating.setUserId(userRating.getUserId());
        existingUserRating.setReliability(userRating.getReliability());
        existingUserRating.setEfficiency(userRating.getEfficiency());
        existingUserRating.setTeamPlayer(userRating.getTeamPlayer());
        userRatingRepository.save(existingUserRating);
        return new ResponseEntity<>(existingUserRating, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserRating(@PathVariable int id) {
        UserRating existingUserRating = userRatingRepository.findById(id).orElse(null);
        if (existingUserRating == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userRatingRepository.delete(existingUserRating);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
