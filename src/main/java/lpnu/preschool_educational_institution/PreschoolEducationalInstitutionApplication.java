package lpnu.preschool_educational_institution;

import lpnu.preschool_educational_institution.entity.Child;
import lpnu.preschool_educational_institution.entity.Trustee;
import lpnu.preschool_educational_institution.repository.ChildRepository;
import lpnu.preschool_educational_institution.repository.TrusteeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.HashSet;

@SpringBootApplication
public abstract class PreschoolEducationalInstitutionApplication {

    public static void main(String[] args) {
        final ApplicationContext context = SpringApplication.run(PreschoolEducationalInstitutionApplication.class, args);

//        final TrusteeRepository trusteeRepository = context.getBean(TrusteeRepository.class);
//        final ChildRepository childRepository = context.getBean(ChildRepository.class);
//
//        Trustee trustee = new Trustee(null, "John", "Doe", "1234567890", "123 Main St", new HashSet<>());
//        trusteeRepository.save(trustee);
//
//        Child child = new Child(null, "Jane", "Doe", LocalDate.now(), new HashSet<>());
//        child.getTrustees().add(trustee);
//        childRepository.save(child);
//
////        trustee.getChildren().add(child);
//
//        trusteeRepository.save(trustee);

    }
}
