package org.reportgenerator;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import org.main.Main;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class DocTemplate {

    public static final String DEST = "c:/temp/Raport.pdf";
    public static final String FONT = "arial.ttf";
    PdfFont polish_font = PdfFontFactory.createFont(FONT, "Cp1250", true);
    PdfDocument pdfDoc = new PdfDocument(new PdfWriter(DEST));
    Document doc = new Document(pdfDoc, PageSize.A4.rotate());
    ImageData imageData = ImageDataFactory.create(uri()+"large_taskster1.png");
    public Image image = new Image(imageData).scaleAbsolute(360,200);

    Paragraph title = new Paragraph("Raport Zestawień")
            .setFontSize(20)
            .setBold()
            .setHorizontalAlignment(HorizontalAlignment.CENTER)
            .setVerticalAlignment(VerticalAlignment.TOP)
            .setFont(polish_font)
            .setTextAlignment(TextAlignment.CENTER);



    public Paragraph getTitle() {
        return title;
    }

    public Image getImage() {
        return image;
    }

    public DocTemplate() throws IOException {
    }

    public PdfFont getPolish_font() {
        return polish_font;
    }

    public void setPolish_font(PdfFont polish_font) {
        this.polish_font = polish_font;
    }

    public Document getDoc() {
        return doc;
    }
    private String uri() {
        String path = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        return URLDecoder.decode(path, StandardCharsets.UTF_8);
    }
    public void setDoc(Document doc) {
        this.doc = doc;
    }
}
