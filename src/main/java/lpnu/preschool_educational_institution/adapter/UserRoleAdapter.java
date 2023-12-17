package lpnu.preschool_educational_institution.adapter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;
import lpnu.preschool_educational_institution.enumeration.UserRole;

import java.util.Objects;

/**
 * JPA AttributeConverter for UserRole enum to Integer database column.
 */
@Convert
public class UserRoleAdapter implements AttributeConverter<UserRole, Integer> {
    /**
     * Converts UserRole to Integer for database storage.
     *
     * @param attribute The UserRole to be converted.
     * @return The Integer representation of the UserRole for database storage.
     */
    @Override
    public Integer convertToDatabaseColumn(final UserRole attribute) {
        return attribute.getCode();
    }

    /**
     * Converts Integer from the database to UserRole.
     *
     * @param dbData The Integer value retrieved from the database.
     * @return The UserRole corresponding to the Integer value.
     * @throws IllegalArgumentException If the database value is null.
     * @throws IllegalArgumentException If the database value is invalid.
     */
    @Override
    public UserRole convertToEntityAttribute(final Integer dbData) {
        if (Objects.isNull(dbData)) {
            throw new IllegalArgumentException("Invalid code. The code for conversion cannot be null.");
        }
        return UserRole.fromCode(dbData);
    }
}
