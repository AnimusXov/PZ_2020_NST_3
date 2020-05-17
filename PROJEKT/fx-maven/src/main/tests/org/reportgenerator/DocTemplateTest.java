package org.reportgenerator;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;

import static org.mockito.Mockito.mock;

class DocTemplateTest {

    private DocTemplate docTemplateUnderTest;

    @BeforeEach
    void setUp() throws IOException {
        docTemplateUnderTest = new DocTemplate();
        docTemplateUnderTest.polish_font = mock(PdfFont.class);
        docTemplateUnderTest.pdfDoc = mock(PdfDocument.class);
        docTemplateUnderTest.doc = mock(Document.class);
    }
}
