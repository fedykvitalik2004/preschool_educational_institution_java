package lpnu.preschool_educational_institution.enumeration;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum DevelopmentMark {
    EXEMPLARY(1,"Exemplary"),
    PROFICIENT(2,"Proficient"),
    ADEQUATE(3,"Adequate"),
    DEVELOPING(4, "Developing"),
    LIMITED(5, "Limited");

    private final int mark;
    private final String name;


    public static DevelopmentMark fromCode(final int mark) {
        return Arrays.stream(DevelopmentMark.values())
                .filter(o -> o.mark == mark)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid code: " + mark + ". Unable to map to a valid DevelopmentMark."));
    }
}
