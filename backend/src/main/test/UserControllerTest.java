package main;

import com.example.myproject.model.User;
import com.example.myproject.repository.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(JUnit4.class)
public class UserControllerTest {

    @Mock
    private UserRepo userRepository;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("testpassword");

        when(userRepository.save(any(User.class))).thenReturn(user);

        ResponseEntity<User> responseEntity = userController.createUser(user);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(user, responseEntity.getBody());
    }

    @Test
    public void testUpdateUser() {
        Long id = 1L;
        User existingUser = new User();
        existingUser.setId(id);
        existingUser.setUsername("testuser");
        existingUser.setPassword("testpassword");

        User updatedUser = new User();
        updatedUser.setId(id);
        updatedUser.setUsername("updateduser");
        updatedUser.setPassword("updatedpassword");

        when(userRepository.findById(id)).thenReturn(Optional.of(existingUser));
        when(userRepository.save(any(User.class))).thenReturn(updatedUser);

        ResponseEntity<User> responseEntity = userController.updateUser(id, updatedUser);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(updatedUser, responseEntity.getBody());
    }

}