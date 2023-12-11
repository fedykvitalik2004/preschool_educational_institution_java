package lpnu.preschool_educational_institution.service.impl;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import lombok.Getter;
import lombok.Setter;
import lpnu.preschool_educational_institution.dto.FormDTO;
import lpnu.preschool_educational_institution.service.FormPdfService;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.function.Supplier;


@Service
public class FormPdfServiceImpl extends FormPdfService {
    private static final String FORM_NAME = "Форми";
    private static final String[] FORM_FIELDS = {"ID", "Імʼя", "Прізвище", "Номер телефону", "Додано"};
    private static final String DATE_CREATED = "Дата:";
    private static final int NUMBER_OF_COLUMNS = 5;
    private static final int TABLE_WIDTH_PERCENTAGE = 100;
    private static final String BOOLEAN_TRUE_REPLACER = "+";
    private static final String BOOLEAN_FALSE_REPLACER = "-";

    @Override
    public byte[] generate(Iterable<FormDTO> data, Supplier<?> dateFunction, Font font) {
        final Document document = new Document();

        try (final ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            final PdfWriter pdfWriter = PdfWriter.getInstance(document, outputStream);
            document.open();

            // Creating name in the top: cell
            final PdfPCell dateCell = new PdfPCell(new Paragraph(FORM_NAME, font));
            dateCell.setBorder(0);
            dateCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            dateCell.setPadding(15f);

            // Adding name in the top: table
            final PdfPTable nameTable = new PdfPTable(1);
            nameTable.getDefaultCell().setBorder(Rectangle.NO_BORDER);
            nameTable.setWidthPercentage(100f);
            nameTable.addCell(dateCell);
            document.add(nameTable);

            // Creating table filled with data
            final PdfPTable dataTable = createTableWithData(data, TABLE_WIDTH_PERCENTAGE, font);
            document.add(dataTable);

            // Adding footer with date
            final TextLeftFooter footer = new TextLeftFooter(DATE_CREATED.concat(
                    " " + dateFunction.get().toString()), font
            );
            footer.onEndPage(pdfWriter, document);

            document.close();
            return outputStream.toByteArray();
        } catch (DocumentException | IOException e) {
            throw new RuntimeException(e);
        } finally {
            document.close();
        }
    }

    private PdfPTable createTableWithData(final Iterable<FormDTO> data, final float widthPercentage, final Font font) {
        final PdfPTable table = createDataTable(NUMBER_OF_COLUMNS, widthPercentage);
        addTableHeaders(table, font, FORM_FIELDS);

        for (final FormDTO form : data) {
            addFormDataCell(table, form, font);
        }
        return table;
    }

    private PdfPTable createDataTable(final int columns, final float widthPercentage) {
        final PdfPTable table = new PdfPTable(columns); // Adjust the number of columns as needed
        table.setWidthPercentage(widthPercentage);
        return table;
    }

    private void addTableHeaders(final PdfPTable table, final Font font, final String... headers) {
        Arrays.stream(headers)
                .map(o -> createCenteredCell(o, font))
                .forEach(table::addCell);
    }

    private void addFormDataCell(final PdfPTable table, final FormDTO form, final Font font) {
        table.addCell(createCenteredCell(String.valueOf(form.getId()), font));
        table.addCell(createCenteredCell(form.getFirstName(), font));
        table.addCell(createCenteredCell(form.getLastName(), font));
        table.addCell(createCenteredCell(form.getMobileNumber(), font));
        table.addCell(createCenteredCell(form.isCompleted() ? BOOLEAN_TRUE_REPLACER : BOOLEAN_FALSE_REPLACER, font));
    }

    private PdfPCell createCenteredCell(String text, Font font) {
        final PdfPCell cell = new PdfPCell(new Paragraph(text, font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        return cell;
    }

    @Getter
    @Setter
    private static class TextLeftFooter extends PdfPageEventHelper {
        private String text;
        private Font font;

        public TextLeftFooter(final String text, final Font font) {
            this.text = text;
            this.font = font;
        }

        @Override
        public void onEndPage(PdfWriter writer, Document document) {
            final Phrase phrase = new Phrase(text, font);

            float x = document.leftMargin();
            float y = document.bottomMargin();

            ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_LEFT, phrase, x, y, 0);
        }
    }
}