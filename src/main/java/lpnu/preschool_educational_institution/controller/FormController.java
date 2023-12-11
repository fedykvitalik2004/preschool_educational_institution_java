package lpnu.preschool_educational_institution.controller;

import lpnu.preschool_educational_institution.dto.FormDTO;
import lpnu.preschool_educational_institution.service.FormService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/forms")
public class FormController {
    private final FormService formService;

    public FormController(FormService formService) {
        this.formService = formService;
    }

    @PostMapping("/create")
    @CrossOrigin()
    public ResponseEntity<?> create(@RequestBody FormDTO formDTO) {
        return ResponseEntity.ok(formService.create(formDTO));
    }
}
