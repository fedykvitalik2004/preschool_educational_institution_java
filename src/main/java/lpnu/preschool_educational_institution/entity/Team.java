package lpnu.preschool_educational_institution.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lpnu.preschool_educational_institution.repository.TeamRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teams")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "team")
    private List<Child> children = new ArrayList<>();
    @ManyToOne
    private User educator;
}
