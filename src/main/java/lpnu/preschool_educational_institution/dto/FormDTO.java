package lpnu.preschool_educational_institution.dto;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FormDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private boolean isCompleted;
}
