package tn.esprit.spring.services;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class UserServiceImplTest {
    @Autowired
    UserServiceImpl userService;

    @Test
    @Order(1)
    public void testIsUserAdult() {
        User user = new User();
        user.setDateNaissance(new Date(System.currentTimeMillis() - 20L * 365 * 24 * 60 * 60 * 1000)); // User is 20 years old
        assertTrue(userService.isUserAdult(user));
    }

    @Test
    @Order(2)
    public void testAddUserToEntreprise() {
        Entreprise entreprise = new Entreprise("TechCorp");
        User user = new User("John", "Doe", new Date(), Role.INGENIEUR);
        userService.addUserToEntreprise(user, entreprise);
        assertEquals(entreprise.getName(), user.getEntreprise().getName());
    }
}
