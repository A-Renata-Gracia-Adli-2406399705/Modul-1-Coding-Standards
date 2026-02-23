package id.ac.ui.cs.advprog.eshop.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HomeControllerTest {

    @Test
    void testHomePage() {
        HomeController controller = new HomeController();
        String view = controller.homePage();
        assertEquals("home", view);
    }
}