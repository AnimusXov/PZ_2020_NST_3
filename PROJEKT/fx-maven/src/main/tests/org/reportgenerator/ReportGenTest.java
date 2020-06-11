package org.reportgenerator;

import com.itextpdf.layout.element.Table;
import org.entities.DepartmentsEntity;
import org.entities.TaskEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.main.TasksController;
import org.service.IGenericService;
import org.utils.ServiceUtils;

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
        reportGenUnderTest.serviceUtils = mock(ServiceUtils.class);
        reportGenUnderTest.emp_con = mock(TasksController.class);
        reportGenUnderTest.objectsFromDb = new ArrayList<>(Arrays.asList(new TaskEntity()));
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
    void testParameterizedArrayGenerator() throws Exception {
        // Setup
        final IGenericService<TaskEntity> service = null;
        final DocTemplate doc = new DocTemplate();

        // Run the test
        reportGenUnderTest.parameterizedArrayGenerator(service, "param1", "param2",new DepartmentsEntity(),true,true,true, doc);

        // Verify the results
    }

    @Test
    void testParameterizedArrayGenerator_ThrowsIOException() throws Exception {
        // Setup
        final IGenericService<TaskEntity> service = null;
        final DocTemplate doc = new DocTemplate();

        // Run the test
        assertThrows(IOException.class, () -> {
            reportGenUnderTest.parameterizedArrayGenerator(service, "param1", "param2",new DepartmentsEntity(),true,true,true, doc);
        });
    }

    @Test
    void testAddHeadersTask() {
        // Setup
        final Table table = new Table(new float[]{0.0f}, false);

        // Run the test
        final Table result = reportGenUnderTest.addHeadersTask(table,true);

        // Verify the results
    }

    @Test
    void testTableGenerator() throws Exception {
        // Setup
        final TaskEntity taskEntity = new TaskEntity();
        taskEntity.setStatus("status");
        taskEntity.setTaskId(0);
        taskEntity.setQuantity((short) 0);
        taskEntity.setDone((short) 0);
        taskEntity.setName("name");
        taskEntity.setIndex("index");
        taskEntity.setPiority("piority");
        final List<TaskEntity> array = Arrays.asList(taskEntity);
        final DocTemplate doc = new DocTemplate();

        // Run the test
        reportGenUnderTest.tableGenerator(array, doc,true);

        // Verify the results
    }

    @Test
    void testTableGenerator_ThrowsIOException() throws Exception {
        // Setup
        final TaskEntity taskEntity = new TaskEntity();
        taskEntity.setStatus("status");
        taskEntity.setTaskId(0);
        taskEntity.setQuantity((short) 0);
        taskEntity.setDone((short) 0);
        taskEntity.setName("name");
        taskEntity.setIndex("index");
        taskEntity.setPiority("piority");
        final List<TaskEntity> array = Arrays.asList(taskEntity);
        final DocTemplate doc = new DocTemplate();

        // Run the test
        assertThrows(IOException.class, () -> {
            reportGenUnderTest.tableGenerator(array, doc,true);
        });
    }

    @Test
    void testEmployeeToTableConverter() throws Exception {
        // Setup
        final DocTemplate doc = new DocTemplate();
        when(reportGenUnderTest.serviceUtils.getEmployeeService()).thenReturn(null);

        // Run the test
        reportGenUnderTest.employeeToTableConverter(doc, false);

        // Verify the results
    }

    @Test
    void testEmployeeToTableConverter_ThrowsIOException() throws Exception {
        // Setup
        final DocTemplate doc = new DocTemplate();
        when(reportGenUnderTest.serviceUtils.getEmployeeService()).thenReturn(null);

        // Run the test
        assertThrows(IOException.class, () -> {
            reportGenUnderTest.employeeToTableConverter(doc, false);
        });
    }

    @Test
    void testEmployeeToTableConverter_ThrowsIllegalAccessException() throws Exception {
        // Setup
        final DocTemplate doc = new DocTemplate();
        when(reportGenUnderTest.serviceUtils.getEmployeeService()).thenReturn(null);

        // Run the test
        assertThrows(IllegalAccessException.class, () -> {
            reportGenUnderTest.employeeToTableConverter(doc, false);
        });
    }

    @Test
    void testCreatePdf() throws Exception {
        // Setup

        // Run the test
        reportGenUnderTest.createPdf("dest");

        // Verify the results
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
