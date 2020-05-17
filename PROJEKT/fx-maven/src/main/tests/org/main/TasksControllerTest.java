package org.main;

import javafx.event.EventType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import org.entities.TaskEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.service.IGenericService;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TasksControllerTest {

    private TasksController tasksControllerUnderTest;

    @BeforeEach
    void setUp() {
        tasksControllerUnderTest = new TasksController();
        tasksControllerUnderTest.taskService = mock(IGenericService.class);
        tasksControllerUnderTest.value = "value";
    }





    @Test
    void testAccessCheck() {
        // Setup

        // Run the test
        tasksControllerUnderTest.accessCheck();

        // Verify the results
    }
}
