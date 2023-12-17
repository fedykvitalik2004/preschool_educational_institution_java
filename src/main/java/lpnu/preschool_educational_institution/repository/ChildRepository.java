package lpnu.preschool_educational_institution.repository;

import lpnu.preschool_educational_institution.entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepository extends JpaRepository<Child, Long> {
}
