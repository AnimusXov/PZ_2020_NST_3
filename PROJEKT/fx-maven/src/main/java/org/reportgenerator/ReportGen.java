package org.reportgenerator;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
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


public class ReportGen {
    ServiceUtils serviceUtils = new ServiceUtils();
    TasksController emp_con = new TasksController();
    ArrayList<TaskEntity> objectsFromDb = new ArrayList<TaskEntity>();
    boolean isSortByDep;







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
        table.addHeaderCell("Nazwa");
        table.addHeaderCell("Indeks");
        table.addHeaderCell("Ilość");
        table.addHeaderCell("Ile Zr.");
        table.addHeaderCell("Status");
        table.addHeaderCell("Piorytet");
        table.addHeaderCell("Departament");

        return table;
    }




public  void tableGenerator(List<TaskEntity> array,DocTemplate doc,boolean isSortByDep) throws IOException {
    doc.doc.setTopMargin(5);
    doc.doc.setBottomMargin(50);
    doc.doc.setFont(doc.getPolish_font());
    Table table = new Table(new  float[]{2,2,1,1,1,1,2});



    table.setBackgroundColor(ColorConstants.LIGHT_GRAY,80);
    table.setKeepTogether(true);

    addHeadersTask(table,isSortByDep);

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


    doc.doc.add(table);



    }

public void WarehouseTableGenerator(DocTemplate doc){
    doc.doc.setTopMargin(100);
    doc.doc.setBottomMargin(50);
    doc.doc.setFont(doc.getPolish_font());
    Table table = new Table(new  float[]{2,2,1,1,1,1});

   table.addHeaderCell("Nazwa");
   table.addHeaderCell("Metale");
   table.addHeaderCell("Drewno");
   table.addHeaderCell("Kompozyty");
   table.addHeaderCell("Marmur");
   table.addHeaderCell("Kamień");

   table.setBackgroundColor(ColorConstants.LIGHT_GRAY, 80);
   table.setKeepTogether(true);

    for (SupplyEntity emp_sup : serviceUtils.getSupplyService().getAll()
    ) {

        table.addCell(new Cell().add(new Paragraph(String.valueOf(emp_sup.getName()))));
        table.addCell(new Cell().add(new Paragraph(String.valueOf(emp_sup.getMetallicMaterials()))));
        table.addCell(new Cell().add(new Paragraph(String.valueOf(emp_sup.getWoodenMaterials()))));
        table.addCell(new Cell().add(new Paragraph(String.valueOf(emp_sup.getComposites()))));
        table.addCell(new Cell().add(new Paragraph(String.valueOf(emp_sup.getMarble()))));
        table.addCell(new Cell().add(new Paragraph(String.valueOf(emp_sup.getStoneMaterials()))));



    }
    doc.doc.add(table);

}







    public void employeeToTableConverter(DocTemplate doc,boolean isDepSelected) throws IOException, IllegalAccessException {
        doc.doc.setTopMargin(100);
        doc.doc.setBottomMargin(50);
        doc.doc.setFont(doc.getPolish_font());
        Table table = new Table(UnitValue.createPercentArray(3)).useAllAvailableWidth();
        if (isDepSelected) {
            table = new Table(new float[]{1, 1, 1});
            table.addHeaderCell("Imię");
            table.addHeaderCell("Nazwisko");
            table.addHeaderCell("Departament");
        } else{
        table = new Table(new float[]{1, 1});
        table.addHeaderCell("Imię");
        table.addHeaderCell("Nazwisko");

    }






        table.setBackgroundColor(ColorConstants.LIGHT_GRAY, 80);

        table.setKeepTogether(true);


        for (EmployeeEntity emp_emp : serviceUtils.getEmployeeService().getAll()
        ) {

            table.addCell(new Cell().add(new Paragraph(String.valueOf(emp_emp.getName()))));
            table.addCell(new Cell().add(new Paragraph(String.valueOf(emp_emp.getSurname()))));
            if(isDepSelected){
                table.addCell(new Cell().add(new Paragraph(String.valueOf(emp_emp.getDepartament().getDep_name()))));
            }

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
