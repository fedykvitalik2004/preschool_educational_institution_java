package lpnu.preschool_educational_institution;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class jh {
    public static void main(String[] args) {
        byte[] array = generatePdfFromList(List.of("Item 1", "Item 2", "Item 3"));
        createPdfFromByteArray(array, "output.pdf");
    }

    public static byte[] generatePdfFromList(List<String> dataList) {
        Document document = new Document();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, byteArrayOutputStream);
            document.open();

            // Add data from the list to the PDF
            for (String data : dataList) {
                document.add(new Paragraph(data));
            }

        } catch (DocumentException e) {
            // Handle DocumentException
            e.printStackTrace();
        } finally {
            document.close();
        }

        return byteArrayOutputStream.toByteArray();
    }

    public static void createPdfFromByteArray(byte[] pdfBytes, String filePath) {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(pdfBytes);
        } catch (IOException e) {
            // Handle IOException
            e.printStackTrace();
        }
    }
}
