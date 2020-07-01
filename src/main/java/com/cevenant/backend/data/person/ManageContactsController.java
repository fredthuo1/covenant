package com.cevenant.backend.data.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin( origins = "http://localhost:3000" )
public class ManageContactsController {

    @Autowired
    final private PersonRepo personRepo;

    @Autowired
    private PersonService personService;

    public ManageContactsController(PersonRepo personRepo, PersonService personService) {
        this.personRepo = personRepo;
        this.personService = personService;
    }

    // Get a list af all the users
    @CrossOrigin( origins = "http://localhost:3000" )
    @RequestMapping( value = "/contacts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> getAllPeople() {
        return personService.findAll();
    }

    // Add new user
    @CrossOrigin( origins = "http://localhost:3000" )
    @RequestMapping( value = "/addPerson", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Person> addPerson(@RequestBody Person person ) {
        personService.save(person);
        System.out.println(person.toString() );
        return new ResponseEntity<Person>(person, HttpStatus.CREATED);
    }

    // Delete user
    @CrossOrigin( origins = "http://localhost:3000" )
    @RequestMapping( value = "/deletePerson/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> deletePerson( @RequestBody Person person ){
        personService.delete(person);
        return new ResponseEntity<Person>(person, HttpStatus.OK);
    }

    // Edit person Info
    @CrossOrigin( origins = "http://localhost:3000" )
    @RequestMapping( value = "/updatePersonInfo", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> editPersonInfo( @RequestBody Person person ){
        List<Person> personList = personService.findAll();
        for ( int i = 0; i <= personList.size(); i++ ) {
            if(person.getId() == personList.get(i).getId()){
                personList.get(i).setFirstName(person.getFirstName());
                personList.get(i).setLastName(person.getLastName());
            }
        }
        return new ResponseEntity<Person>(person, HttpStatus.OK);
    }

    // Get user profile
    @CrossOrigin( origins = "http://localhost:3000" )
    @RequestMapping( value = "/getPerson", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public Optional<Person> getUserProfile(@RequestParam Long id ) {
        Optional<Person> person = personService.findById(id);
        System.out.println(person);
        return person;
    }
}
