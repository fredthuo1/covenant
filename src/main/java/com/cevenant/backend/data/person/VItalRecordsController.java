package com.cevenant.backend.data.person;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
public class VItalRecordsController {

    final private PersonService personService;

    public VItalRecordsController(PersonService personService) {
        this.personService = personService;
    }

   @CrossOrigin( origins = "http://localhost:3000" )
   @RequestMapping( value = "/birthdays", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> peopleBirthday(@RequestParam Date date) {
        List<Person> people = personService.findAll();
       ArrayList<Person> birthDays = new ArrayList<>();
       people.forEach(person -> {
           if(person.getBirthDate().equals(date)){
               people.add(person);
           }
       });
        return people;
   }

    @CrossOrigin( origins = "http://localhost:300" )
    @RequestMapping( value = "/weeklyBirthdays", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> peopleWeeklyBirthday( @RequestParam Date date ) {
        List<Person> people = personService.findAll();
        ArrayList<Person> birthDays = new ArrayList<>();

        LocalDate today = LocalDate.now();
        LocalDate monday = today;
        while (monday.getDayOfWeek() != DayOfWeek.MONDAY) {
            monday = monday.minusDays(1);
        }

        for ( int i = 0; i <= 6; i++ ) {
            LocalDate finalMonday = monday.plusDays(i);

            people.forEach(person -> {
                if (person.getBirthDate().equals(finalMonday)){
                    people.add(person);
                }

            });
        }
        return people;
    }

    @CrossOrigin( origins = "http://localhost:3000")
    @RequestMapping( value = "monthlyBirthDays", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> peopleMonthlyBirthdays(@RequestParam Date date){
        List<Person> people = personService.findAll();
        ArrayList<Person> birthDays = new ArrayList<>();

        LocalDate date1 = LocalDate.now();
        int days = date1.getMonth().maxLength();
        while ( date1.getDayOfMonth() != 1 ){
            date1 = date1.minusDays(1);
        }

        for ( int i = 0 ; i <= days - 1; i++ ) {
            LocalDate finalFirst = date1.plusDays(i);
            people.forEach(person -> {
                if ( person.getBirthDate().equals(finalFirst) ){
                    birthDays.add(person);
                }
            });
        }
        return birthDays;
    }


}
