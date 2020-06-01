package org.reportgenerator;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;

import java.io.File;
import java.io.IOException;

public class DocTemplate {
    public static final String DEST = "c:/temp/Raport.pdf";
    public static final String FONT = "arial.ttf";
    PdfFont polish_font = PdfFontFactory.createFont(FONT, "Cp1250", true);
    PdfDocument pdfDoc = new PdfDocument(new PdfWriter(DEST));
    Document doc = new Document(pdfDoc, PageSize.A4.rotate());

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

    public void setDoc(Document doc) {
        this.doc = doc;
    }
}
