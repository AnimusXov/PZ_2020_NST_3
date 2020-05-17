package org.main;

import javafx.scene.layout.AnchorPane;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class MainControllerTest {
    AnchorPane testPane = new AnchorPane();

    private MainController mainControllerUnderTest;

    @BeforeEach
    void setUp() {
        mainControllerUnderTest = new MainController();
    }




    @Test
    void testAccessCheck() {
        // Setup

        // Run the test
        mainControllerUnderTest.accessCheck();

        // Verify the results
    }


}
