package lpnu.preschool_educational_institution.service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.BaseFont;

import java.util.Map;

public abstract class PdfService {
    protected static Map<String, Font> fonts = Map.of(
            "Mirror", FontFactory.getFont("./src/main/resources/fonts/mirror_82_v2.otf",
                    BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 12f, Font.NORMAL, BaseColor.BLACK)

    );
}
