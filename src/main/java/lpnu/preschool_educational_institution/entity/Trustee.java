package lpnu.preschool_educational_institution.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "trustees")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Trustee {
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
    @Column(name = "address")
    private String address;
    @ManyToMany
    @JoinTable(
            name = "trustee_child_association",
            joinColumns = {@JoinColumn(name = "trustee_id")},
            inverseJoinColumns = {@JoinColumn(name = "child_id")},
            foreignKey = @ForeignKey(name = "FK_TRUSTEE"),
            inverseForeignKey = @ForeignKey(name = "FK_CHILD")
    )
    private List<Child> children = new ArrayList<>();

    public void addChild(Child child) {
        children.add(child);
        child.getTrustees().add(this);
    }
}
