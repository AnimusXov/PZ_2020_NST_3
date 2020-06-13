package org.reportgenerator;

import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.property.AreaBreakType;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import org.entities.DepartmentsEntity;
import org.entities.EmployeeEntity;
import org.entities.SupplyEntity;
import org.entities.TaskEntity;
import org.main.TasksController;
import org.service.IGenericService;
import org.utils.ServiceUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static com.itextpdf.kernel.colors.ColorConstants.BLUE;


public class ReportGen {
    ServiceUtils serviceUtils = new ServiceUtils();
    TasksController emp_con = new TasksController();
    ArrayList<TaskEntity> objectsFromDb = new ArrayList<TaskEntity>();
    boolean isSortByDep;
    Color headersColors = new DeviceRgb(140,198,63);
    Color tableColor = new DeviceRgb(209,226,186);



    Div generateTitle(Paragraph title){
        title.setTextAlignment(TextAlignment.CENTER)
                .setBold()
                .setFontSize(15)
                .setMarginBottom(0);
        return new Div()
                .add(title)
                .setMarginBottom(18);
    }


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


    public void parameterizedArrayGenerator(IGenericService<TaskEntity> service, String priority,
                                            String status, DepartmentsEntity department,
            boolean isPio, boolean isStatus, boolean isDep, DocTemplate doc)
            throws IOException {
        List<TaskEntity> parameterized_Array = new ArrayList<>(service.getAll());



        if (isPio) {
            parameterized_Array.removeIf(emp -> !(emp.getStatus().equals(
                    status)));
        }

        if (isStatus){
            parameterized_Array.removeIf(emp -> !(emp.getPiority().equals(
                    priority)));
        }

        if(isDep){
            parameterized_Array.removeIf(emp -> !(emp.getDepartament().getDep_name().equals(
                    department.getDep_name())));
             isSortByDep = true;
        }

        tableGenerator(parameterized_Array,doc,isSortByDep);
    

    }

    public Table addHeadersTask(Table table,boolean isSortByDep){


        Paragraph header1 = new Paragraph("Nazwa");
        Paragraph header2 = new Paragraph("Indeks");
        Paragraph header3 = new Paragraph("Ilość");
        Paragraph header4 = new Paragraph("Ile Zr.");
        Paragraph header5 = new Paragraph("Status");
        Paragraph header6 = new Paragraph("Piorytet");
        Paragraph header7 = new Paragraph("Departament");
        header1.setBold()
                .setBackgroundColor(headersColors);
        header2.setBold()
                .setBackgroundColor(headersColors);
        header3.setBold()
                .setBackgroundColor(headersColors);
        header4.setBold()
                .setBackgroundColor(headersColors);
        header5.setBold()
                .setBackgroundColor(headersColors);
        header6.setBold()
                .setBackgroundColor(headersColors);
        header7.setBold()
                .setBackgroundColor(headersColors);
        table.addHeaderCell(header1);
        table.addHeaderCell(header2);
        table.addHeaderCell(header3);
        table.addHeaderCell(header4);
        table.addHeaderCell(header5);
        table.addHeaderCell(header6);
        table.addHeaderCell(header7);


        return table;
    }
    public Table addSupplyHeaders(Table table){
        Paragraph header1 = new Paragraph("Nazwa");
        Paragraph header2 = new Paragraph("Metale");
        Paragraph header3 = new Paragraph("Drewno");
        Paragraph header4 = new Paragraph("Kompozyty");
        Paragraph header5 = new Paragraph("Marmur");
        Paragraph header6 = new Paragraph("Kamień");
        header1.setBold()
                .setBackgroundColor(headersColors);
        header2.setBold()
                .setBackgroundColor(headersColors);
        header3.setBold()
                .setBackgroundColor(headersColors);
        header4.setBold()
                .setBackgroundColor(headersColors);
        header5.setBold()
                .setBackgroundColor(headersColors);
        header6.setBold()
                .setBackgroundColor(headersColors);
        table.addHeaderCell(header1);
        table.addHeaderCell(header2);
        table.addHeaderCell(header3);
        table.addHeaderCell(header4);
        table.addHeaderCell(header5);
        table.addHeaderCell(header6);
        return table;
    }




public  void tableGenerator(List<TaskEntity> array,DocTemplate doc,boolean isSortByDep) throws IOException {
    doc.doc.setTopMargin(5);
    doc.doc.setBottomMargin(50);
    doc.doc.setFont(doc.getPolish_font());

    Table table = new Table(new  float[]{2,2,1,1,1,1,2});



    table.setBackgroundColor(tableColor);
    table.setKeepTogether(true);

    addHeadersTask(table,isSortByDep);
    Paragraph title = new Paragraph("Zestawienie Zadań")
            .setTextAlignment(TextAlignment.CENTER)
            .setFontSize(15);


    for (TaskEntity emp_ent:array
         ) {
        table.addCell(new Cell().add(new Paragraph(String.valueOf(emp_ent.getName()))));
        table.addCell(new Cell().add(new Paragraph(String.valueOf(emp_ent.getIndex()))));
        table.addCell(new Cell().add(new Paragraph(String.valueOf(emp_ent.getQuantity()))));
        table.addCell(new Cell().add(new Paragraph(String.valueOf(emp_ent.getDone()))));
        table.addCell(new Cell().add(new Paragraph(String.valueOf(emp_ent.getStatus()))));
        table.addCell(new Cell().add(new Paragraph(String.valueOf(emp_ent.getPiority()))));
        table.addCell(new Cell().add(new Paragraph(String.valueOf(emp_ent.getDepartament().getDep_name()))));

        
    }

    table.setHorizontalAlignment(HorizontalAlignment.CENTER);
    doc.doc.add(title);
    doc.doc.add(table);



    }

public void WarehouseTableGenerator(DocTemplate doc){
    doc.doc.setTopMargin(100);
    doc.doc.setBottomMargin(50);
    doc.doc.setFont(doc.getPolish_font());
    Table table = new Table(new  float[]{2,2,1,1,1,1});




   table.setBackgroundColor(tableColor);
   table.setKeepTogether(true);

    addSupplyHeaders(table);
    doc.doc.add(new AreaBreak(AreaBreakType.NEXT_PAGE));

    Paragraph title = new Paragraph("Zestawienie Magazynów");

    for (SupplyEntity emp_sup : serviceUtils.getSupplyService().getAll()
    ) {

        table.addCell(new Cell().add(new Paragraph(String.valueOf(emp_sup.getName()))));
        table.addCell(new Cell().add(new Paragraph(String.valueOf(emp_sup.getMetallicMaterials()))));
        table.addCell(new Cell().add(new Paragraph(String.valueOf(emp_sup.getWoodenMaterials()))));
        table.addCell(new Cell().add(new Paragraph(String.valueOf(emp_sup.getComposites()))));
        table.addCell(new Cell().add(new Paragraph(String.valueOf(emp_sup.getMarble()))));
        table.addCell(new Cell().add(new Paragraph(String.valueOf(emp_sup.getStoneMaterials()))));



    }
    table.setHorizontalAlignment(HorizontalAlignment.CENTER);
    doc.doc.add(generateTitle(title));
    doc.doc.add(table);

}







    public void employeeToTableConverter(DocTemplate doc,boolean isDepSelected) throws IOException, IllegalAccessException {
        doc.doc.setTopMargin(100);
        doc.doc.setBottomMargin(50);
        doc.doc.setFont(doc.getPolish_font());
        Table table = new Table(UnitValue.createPercentArray(3)).useAllAvailableWidth();
        Paragraph title = new Paragraph("Zestawienie Pracowników");
       doc.doc.add(generateTitle(title));
       Paragraph header1 = new Paragraph("Imię");
       Paragraph header2 = new Paragraph("Nazwisko");
       Paragraph header3 = new Paragraph("Departament");
        header1.setBold()
                .setBackgroundColor(headersColors);
        header2.setBold()
                .setBackgroundColor(headersColors);
        header3.setBold()
                .setBackgroundColor(headersColors);
        if (isDepSelected) {
            table = new Table(new float[]{1, 1, 1});
            table.addHeaderCell(header1);
            table.addHeaderCell(header2);
            table.addHeaderCell(header3);

        } else{
            table = new Table(new float[]{1, 1});
       table.addHeaderCell(header1);
       table.addHeaderCell(header2);
    }






        table.setBackgroundColor(tableColor);

        table.setKeepTogether(true);
        table.setHorizontalAlignment(HorizontalAlignment.CENTER);

        for (EmployeeEntity emp_emp : serviceUtils.getEmployeeService().getAll()
        ) {

            table.addCell(new Cell().add(new Paragraph(String.valueOf(emp_emp.getName()))));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(emp_emp.getSurname()))));
            if(isDepSelected){
                table.addCell(new Cell().add(new Paragraph(String.valueOf(emp_emp.getDepartament().getDep_name()))));
            }

        }

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
