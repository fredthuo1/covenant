package com.cevenant.backend.data.person;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class CorrespondenceController {

    final private PersonService personService;

    public CorrespondenceController(PersonService personService) {
        this.personService = personService;
    }

}
