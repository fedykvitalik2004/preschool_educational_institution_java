package lpnu.preschool_educational_institution.adapter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;
import lpnu.preschool_educational_institution.enumeration.DevelopmentMark;
import lpnu.preschool_educational_institution.enumeration.UserRole;

import java.util.Objects;

@Convert
public class DevelopmentMarkAdapter implements AttributeConverter<DevelopmentMark, Integer> {

    @Override
    public Integer convertToDatabaseColumn(DevelopmentMark attribute) {
        return attribute.getMark();
    }

    @Override
    public DevelopmentMark convertToEntityAttribute(Integer dbData) {
        if (Objects.isNull(dbData)) {
            throw new IllegalArgumentException("Invalid code. The code for conversion cannot be null.");
        }
        return DevelopmentMark.fromCode(dbData);
    }
}
