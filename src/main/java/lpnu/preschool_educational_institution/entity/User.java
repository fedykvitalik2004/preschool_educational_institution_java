package lpnu.preschool_educational_institution.entity;

import jakarta.persistence.*;
import lombok.*;
import lpnu.preschool_educational_institution.adapter.UserRoleAdapter;
import lpnu.preschool_educational_institution.enumeration.UserRole;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "mobile_number")
    private String mobileNumber;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "date_of_creation")
    @CreatedDate
    private LocalDate dateOfCreation;
    @Column(name = "role")
    @Convert(converter = UserRoleAdapter.class)
    private UserRole role;
    @OneToMany(mappedBy = "educator")
    private List<Team> teams = new ArrayList<>();
// TODO: add photo support
}
