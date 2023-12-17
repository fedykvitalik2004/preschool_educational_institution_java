package lpnu.preschool_educational_institution.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "children")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    // TODO: image
    @ManyToMany(mappedBy = "children")
    private List<Trustee> trustees = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public void addTrustee(Trustee trustee) {
        trustees.add(trustee);
        trustee.getChildren().add(this);
    }
}
