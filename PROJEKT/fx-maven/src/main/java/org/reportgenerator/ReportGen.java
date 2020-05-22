package org.reportgenerator;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import org.entities.EmployeeEntity;
import org.entities.TaskEntity;
import org.hibernateutil.HibernateUtil;
import org.main.TasksController;
import org.service.GenericServiceImpl;
import org.service.IGenericService;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ReportGen {

    TasksController emp_con = new TasksController();
    ArrayList<TaskEntity> objectsFromDb = new ArrayList<TaskEntity>();

    IGenericService<TaskEntity> taskService = new GenericServiceImpl<>(
            TaskEntity.class, HibernateUtil.getSessionFactory());
    IGenericService<EmployeeEntity> employeeService = new GenericServiceImpl<>(
            EmployeeEntity.class, HibernateUtil.getSessionFactory());







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

    public void testGeneric(Object obj){
        IGenericService<Object> objectService = new GenericServiceImpl<>(
                Object.class, HibernateUtil.getSessionFactory());
        Class<?> c = obj.getClass();
        Field[] fields = c.getDeclaredFields();
        Map<String, Object> temp = new HashMap<String, Object>();

        for( Field field : fields ){
            try {
                temp.put(field.getName().toString(), field.get(obj));
            } catch (IllegalArgumentException | IllegalAccessException e1) {
                e1.printStackTrace();
            }
        }

    }
    public void whatStatus(){


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

        for (TaskEntity emp_ent:taskService.getAll()
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


        for (EmployeeEntity emp_emp : employeeService.getAll()
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
