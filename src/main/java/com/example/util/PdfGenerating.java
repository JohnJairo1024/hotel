package com.example.util;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;


public class PdfGenerating {


    private static final Logger log = LoggerFactory.getLogger(PdfGenerating.class);

    public void testPdf(String filename) throws FileNotFoundException {
        File file = new File(filename + ".pdf");
        file.getParentFile().mkdirs();

        PdfWriter writer = new PdfWriter(filename + ".pdf");
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);
        document.add(new Paragraph(filename));
        document.close();

    }

}
