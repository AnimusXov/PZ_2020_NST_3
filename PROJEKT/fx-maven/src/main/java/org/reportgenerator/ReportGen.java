package org.reportgenerator;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import org.entities.EmployeeEntity;
import org.entities.TaskEntity;
import org.main.TasksController;
import org.service.IGenericService;
import org.utils.ServiceUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;


public class ReportGen {
    ServiceUtils serviceUtils = new ServiceUtils();
    TasksController emp_con = new TasksController();
    ArrayList<TaskEntity> objectsFromDb = new ArrayList<TaskEntity>();







    public ReportGen() throws IOException {
    }

    public boolean isEmpty() throws IllegalAccessException {
        for (Field f : getClass().getDeclaredFields())
        {
            f.setAccessible(true);
            return f.get(this) =="";
        }
        return false;
    }

    public static void initialize() throws IOException, IllegalAccessException {
        File file = new File(DocTemplate.DEST);
        file.getParentFile().mkdirs();
    }


    public void parameterizedArrayGenerator(IGenericService<TaskEntity> service, String param1,DocTemplate doc) throws IOException {

        List<TaskEntity> parameterized_Array = new ArrayList<>(service.getAll());
        IntStream rev1;
        IntStream rev2;
        System.out.println(Arrays.toString(param1.getBytes()));
        System.out.println(param1);
        for (TaskEntity emp:parameterized_Array
             ) {System.out.println(Arrays.toString(emp.getStatus().getBytes()) + emp.getStatus());

        }

       parameterized_Array.removeIf(emp -> !(emp.getStatus().equals(
             param1)));


        tableGenerator(parameterized_Array,doc);
    

    }

    public Table addHeadersTask(Table table){
        table.addHeaderCell("Nazwa");
        table.addHeaderCell("Indeks");
        table.addHeaderCell("Ilość");
        table.addHeaderCell("Ile Zr.");
        table.addHeaderCell("Status");
        table.addHeaderCell("Piorytet");
        return table;
    }




public  void tableGenerator(List<TaskEntity> array,DocTemplate doc) throws IOException {
    doc.doc.setTopMargin(5);
    doc.doc.setBottomMargin(50);
    doc.doc.setFont(doc.getPolish_font());
    Table table = new Table(new  float[]{2,2,1,1,1,1});
    table.setBackgroundColor(ColorConstants.LIGHT_GRAY,80);
    table.setKeepTogether(true);
    addHeadersTask(table);
    for (TaskEntity emp_ent:array
         ) {
        table.addCell(new Cell().add(new Paragraph(String.valueOf(emp_ent.getName()))));
        table.addCell(new Cell().add(new Paragraph(String.valueOf(emp_ent.getIndex()))));
        table.addCell(new Cell().add(new Paragraph(String.valueOf(emp_ent.getQuantity()))));
        table.addCell(new Cell().add(new Paragraph(String.valueOf(emp_ent.getDone()))));
        table.addCell(new Cell().add(new Paragraph(String.valueOf(emp_ent.getStatus()))));
        table.addCell(new Cell().add(new Paragraph(String.valueOf(emp_ent.getPiority()))));
        
    }
    doc.doc.add(table);



    }








    public void taskToTableConverter(DocTemplate doc) throws IOException, IllegalAccessException {
        doc.doc.setTopMargin(5);
        doc.doc.setBottomMargin(50);
        doc.doc.setFont(doc.getPolish_font());
        Table table = new Table(new  float[]{2,2,1,1,1,1});
        table.addHeaderCell("Nazwa");
        table.addHeaderCell("Indeks");
        table.addHeaderCell("Ilość");
        table.addHeaderCell("Ile Zr.");
        table.addHeaderCell("Status");
        table.addHeaderCell("Piorytet");

        table.setBackgroundColor(ColorConstants.LIGHT_GRAY,80);
        table.setKeepTogether(true);

        for (TaskEntity emp_ent: serviceUtils.getTaskService().getAll()
             ) {
            table.addCell(new Cell().add(new Paragraph(String.valueOf(emp_ent.getName()))));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(emp_ent.getIndex()))));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(emp_ent.getQuantity()))));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(emp_ent.getDone()))));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(emp_ent.getStatus()))));
            if(!isEmpty()) {
                table.addCell(new Cell().add(new Paragraph(String.valueOf(emp_ent.getPiority()))));
            }

        }
        doc.doc.add(table);


    }
    public void employeeToTableConverter(DocTemplate doc) throws IOException, IllegalAccessException {
        doc.doc.setTopMargin(100);
        doc.doc.setBottomMargin(50);
        doc.doc.setFont(doc.getPolish_font());


        Table table = new Table(new float[]{2, 2});
        table.addHeaderCell("Imię");
        table.addHeaderCell("Nazwisko");

        table.setBackgroundColor(ColorConstants.LIGHT_GRAY, 80);

        table.setKeepTogether(true);


        for (EmployeeEntity emp_emp : serviceUtils.getEmployeeService().getAll()
        ) {

            table.addCell(new Cell().add(new Paragraph(String.valueOf(emp_emp.getName()))));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(emp_emp.getSurname()))));

        }
   table.setHorizontalBorderSpacing(5);
        doc.doc.add(table);


    }



    public void createPdf(String dest) throws IOException {
        //Initialize PDF writer
        PdfWriter writer = new PdfWriter(dest);

        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);

        // Initialize document
        Document document = new Document(pdf);

        //Close document
        document.close();
    }
}
