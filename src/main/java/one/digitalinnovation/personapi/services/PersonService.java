package one.digitalinnovation.personapi.services;

import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.entities.Person;
import one.digitalinnovation.personapi.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository)
    {
        this.personRepository = personRepository;
    }


    @PostMapping
    public MessageResponseDTO createPerson(Person person)
    {
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO.builder().message("Created person with Id "+savedPerson.getId()).build();
    }


}
