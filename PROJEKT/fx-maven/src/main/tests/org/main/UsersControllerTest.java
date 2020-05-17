package org.main;

import javafx.event.EventType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import org.entities.EmployeeEntity;
import org.entities.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.service.IGenericService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class UsersControllerTest {

    private UsersController usersControllerUnderTest;

    @BeforeEach
    void setUp() {
        usersControllerUnderTest = new UsersController();
        usersControllerUnderTest.usersService = mock(IGenericService.class);
        usersControllerUnderTest.employeeSerive = mock(IGenericService.class);
    }

}
