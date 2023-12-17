package lpnu.preschool_educational_institution.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lpnu.preschool_educational_institution.adapter.DevelopmentMarkAdapter;
import lpnu.preschool_educational_institution.enumeration.DevelopmentMark;

import java.time.LocalDate;

@Entity
@Table(name = "attendance")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "cognitive_development_mark")
    @Convert(converter = DevelopmentMarkAdapter.class)
    private DevelopmentMark cognitiveDevelopmentMark;
    @Column(name = "social_development_mark")
    @Convert(converter = DevelopmentMarkAdapter.class)
    private DevelopmentMark socialDevelopmentMark;
    @Column(name = "creative_development_mark")
    @Convert(converter = DevelopmentMarkAdapter.class)
    private DevelopmentMark creativeDevelopmentMark;
    @ManyToOne
    @JoinColumn(name = "child_id")
    private Child child;
}
