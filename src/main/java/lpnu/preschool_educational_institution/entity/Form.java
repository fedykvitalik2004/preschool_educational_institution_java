package lpnu.preschool_educational_institution.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "forms")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "mobile_number")
    private String mobileNumber;
    @Column(name = "is_completed")
    private boolean isCompleted;
}
