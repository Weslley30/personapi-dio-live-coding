package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.dto.MessageResponseDTO;
import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.mapper.PersonMapper;
import one.digitalinnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import one.digitalinnovation.personapi.dto.request.PersonDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.stream.Collector;

@Service
public class PersonService {
        private PersonRepository personRepository;

        private final PersonMApper personMApper = PersonMapper.INSTANCE;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Autowired

    public MessageResponseDTO createPerson(PersonDTO){
        Person personToSave = Person.builder()
                .firstName(PersonDTO.getFirstName())
                .lastName(PersonDTO.getLastName())
                .birthDate(PersonDTO.getBirthDate())
                .phone(PersonDTO.getPhones())
                .build();
    }

    public MessageResponseDTO createPerson(Person person){
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }
    public List<PersonDTO> listAll(){
        List<Phone> allPeople = personRepository.findAll();
        return allPeople.stream(){
            .map(personMapper::toDTO);
            .collect(Collectors.toList());
        }
    }
}
