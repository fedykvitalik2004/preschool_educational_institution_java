package lpnu.preschool_educational_institution.service;

import com.itextpdf.text.Font;
import lpnu.preschool_educational_institution.dto.FormDTO;

import java.util.function.Supplier;

public abstract class FormPdfService extends PdfService {
    public abstract byte[] generate(Iterable<FormDTO> data, Supplier<?> dateFunction, Font font);
}
