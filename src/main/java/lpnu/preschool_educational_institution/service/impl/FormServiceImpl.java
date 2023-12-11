package lpnu.preschool_educational_institution.service.impl;

import lpnu.preschool_educational_institution.dto.FormDTO;
import lpnu.preschool_educational_institution.entity.Form;
import lpnu.preschool_educational_institution.mapper.FormMapper;
import lpnu.preschool_educational_institution.repository.FormRepository;
import lpnu.preschool_educational_institution.service.FormService;
import org.springframework.stereotype.Service;

@Service
public class FormServiceImpl implements FormService {
    private final FormRepository formRepository;
    private final FormMapper formMapper;

    public FormServiceImpl(final FormRepository formRepository, final FormMapper formMapper) {
        this.formRepository = formRepository;
        this.formMapper = formMapper;
    }

    @Override
    public FormDTO create(FormDTO formDTO) {
        Form form = formMapper.toEntity(formDTO);

        Form savedForm = formRepository.save(form);

        return formMapper.toDTO(savedForm);
    }
}
