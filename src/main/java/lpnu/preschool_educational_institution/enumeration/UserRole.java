package lpnu.preschool_educational_institution.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum UserRole {
    ADMIN(0),
    TEACHER(1);

    private final int code;

     /**
     * Retrieves the UserRole based on its code.
     *
     * @param code The code associated with the UserRole.
     * @return The UserRole corresponding to the provided code.
     * @throws IllegalArgumentException If the provided code is invalid.
     */
    public static UserRole fromCode(final int code) {
        return Arrays.stream(UserRole.values())
                .filter(o -> o.code == code)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid code: " + code + ". Unable to map to a valid UserRole."));
    }
}
