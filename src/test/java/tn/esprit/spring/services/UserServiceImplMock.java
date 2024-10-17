package tn.esprit.spring.services;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;

import java.util.Optional;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
class UserServiceImplMock {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private User mockUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockUser = new User(1L, "John", "Doe", null, Role.INGENIEUR);
    }

    @Test
    void testFindUserById() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(mockUser));

        User foundUser = userService.findUserById(1L);
        assertNotNull(foundUser);
        assertEquals("John", foundUser.getLastName());
    }
}
