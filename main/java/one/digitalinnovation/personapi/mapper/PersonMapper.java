package one.digitalinnovation.personapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import one.digitalinnovation.personapi.dto.request.PersonDTO;
import  one.digitalinnovation.personapi.entity.Person;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @mapping(target = "birthDate", source = "birtDate", dateFormat = "dd-MM-yyyy")
    Person toModel (PersonDTO PersonDTO);

    PersonDTO toDTO(Person person);
}
