package org.reportgenerator;

import org.entities.EmployeeEntity;
import org.entities.TaskEntity;
import org.entities.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.main.TasksController;
import org.service.IGenericService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ReportGenTest {

    private ReportGen reportGenUnderTest;

    @BeforeEach
    void setUp() throws IOException {
        reportGenUnderTest = new ReportGen();
        reportGenUnderTest.emp_con = mock(TasksController.class);
        reportGenUnderTest.objectsFromDb = new ArrayList<>(Arrays.asList(new TaskEntity()));
        reportGenUnderTest.taskService = mock(IGenericService.class);
        reportGenUnderTest.employeeService = mock(IGenericService.class);
    }

    @Test
    void testIsEmpty() throws Exception {
        // Setup

        // Run the test
        final boolean result = reportGenUnderTest.isEmpty();

        // Verify the results
        assertTrue(result);
    }

    @Test
    void testIsEmpty_ThrowsIllegalAccessException() {
        // Setup

        // Run the test
        assertThrows(IllegalAccessException.class, () -> {
            reportGenUnderTest.isEmpty();
        });
    }

    @Test
    void testTestGeneric() {
        // Setup

        // Run the test
        reportGenUnderTest.testGeneric("obj");

        // Verify the results
    }

    @Test
    void testTaskToTableConverter() throws Exception {
        // Setup
        final DocTemplate doc = new DocTemplate();

        // Configure IGenericService.getAll(...).
        final TaskEntity taskEntity = new TaskEntity();
        taskEntity.setStatus("status");
        taskEntity.setTaskId(0);
        taskEntity.setQuantity((short) 0);
        taskEntity.setDone((short) 0);
        taskEntity.setName("name");
        taskEntity.setIndex("index");
        taskEntity.setPiority("piority");
        final List<TaskEntity> taskEntities = Arrays.asList(taskEntity);
        when(reportGenUnderTest.taskService.getAll()).thenReturn(taskEntities);

        // Run the test
        reportGenUnderTest.taskToTableConverter(doc);

        // Verify the results
    }

    @Test
    void testTaskToTableConverter_ThrowsIOException() throws Exception {
        // Setup
        final DocTemplate doc = new DocTemplate();

        // Configure IGenericService.getAll(...).
        final TaskEntity taskEntity = new TaskEntity();
        taskEntity.setStatus("status");
        taskEntity.setTaskId(0);
        taskEntity.setQuantity((short) 0);
        taskEntity.setDone((short) 0);
        taskEntity.setName("name");
        taskEntity.setIndex("index");
        taskEntity.setPiority("piority");
        final List<TaskEntity> taskEntities = Arrays.asList(taskEntity);
        when(reportGenUnderTest.taskService.getAll()).thenReturn(taskEntities);

        // Run the test
        assertThrows(IOException.class, () -> {
            reportGenUnderTest.taskToTableConverter(doc);
        });
    }

    @Test
    void testTaskToTableConverter_ThrowsIllegalAccessException() throws Exception {
        // Setup
        final DocTemplate doc = new DocTemplate();

        // Configure IGenericService.getAll(...).
        final TaskEntity taskEntity = new TaskEntity();
        taskEntity.setStatus("status");
        taskEntity.setTaskId(0);
        taskEntity.setQuantity((short) 0);
        taskEntity.setDone((short) 0);
        taskEntity.setName("name");
        taskEntity.setIndex("index");
        taskEntity.setPiority("piority");
        final List<TaskEntity> taskEntities = Arrays.asList(taskEntity);
        when(reportGenUnderTest.taskService.getAll()).thenReturn(taskEntities);

        // Run the test
        assertThrows(IllegalAccessException.class, () -> {
            reportGenUnderTest.taskToTableConverter(doc);
        });
    }

    @Test
    void testEmployeeToTableConverter() throws Exception {
        // Setup
        final DocTemplate doc = new DocTemplate();

        // Configure IGenericService.getAll(...).
        final EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName("name");
        employeeEntity.setSurname("surname");
        employeeEntity.setId(0);
        final UserEntity userEntity = new UserEntity();
        userEntity.setUsername("username");
        userEntity.setPassword("password");
        userEntity.setAccess_level(0);
        userEntity.setId(0);
        userEntity.setEmployeeEntity(new EmployeeEntity());
        employeeEntity.setUser(userEntity);
        final List<EmployeeEntity> employeeEntities = Arrays.asList(employeeEntity);
        when(reportGenUnderTest.employeeService.getAll()).thenReturn(employeeEntities);

        // Run the test
        reportGenUnderTest.employeeToTableConverter(doc);

        // Verify the results
    }



    @Test
    void testEmployeeToTableConverter_ThrowsIllegalAccessException() throws Exception {
        // Setup
        final DocTemplate doc = new DocTemplate();

        // Configure IGenericService.getAll(...).
        final EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName("name");
        employeeEntity.setSurname("surname");
        employeeEntity.setId(0);
        final UserEntity userEntity = new UserEntity();
        userEntity.setUsername("username");
        userEntity.setPassword("password");
        userEntity.setAccess_level(0);
        userEntity.setId(0);
        userEntity.setEmployeeEntity(new EmployeeEntity());
        employeeEntity.setUser(userEntity);
        final List<EmployeeEntity> employeeEntities = Arrays.asList(employeeEntity);
        when(reportGenUnderTest.employeeService.getAll()).thenReturn(employeeEntities);

        // Run the test
        assertThrows(IllegalAccessException.class, () -> {
            reportGenUnderTest.employeeToTableConverter(doc);
        });
    }



    @Test
    void testCreatePdf_ThrowsIOException() {
        // Setup

        // Run the test
        assertThrows(IOException.class, () -> {
            reportGenUnderTest.createPdf("dest");
        });
    }

    @Test
    void testInitialize() throws Exception {
        // Setup

        // Run the test
        ReportGen.initialize();

        // Verify the results
    }

    @Test
    void testInitialize_ThrowsIOException() {
        // Setup

        // Run the test
        assertThrows(IOException.class, () -> {
            ReportGen.initialize();
        });
    }

    @Test
    void testInitialize_ThrowsIllegalAccessException() {
        // Setup

        // Run the test
        assertThrows(IllegalAccessException.class, () -> {
            ReportGen.initialize();
        });
    }
}
