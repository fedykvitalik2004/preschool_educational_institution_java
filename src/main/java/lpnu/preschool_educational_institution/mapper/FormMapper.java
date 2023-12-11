package lpnu.preschool_educational_institution.mapper;

import lpnu.preschool_educational_institution.dto.FormDTO;
import lpnu.preschool_educational_institution.entity.Form;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FormMapper {
    Form toEntity(FormDTO formDTO);
    FormDTO toDTO(Form form);
}
