package com.cevenant.backend.data.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ContactAnalysisController {

    @Autowired
    final private PersonService personService;
    final private MemberAnalysisService memberAnalysisService;

    public ContactAnalysisController(PersonService personService, MemberAnalysisService memberAnalysisService) {
        this.personService = personService;
        this.memberAnalysisService = memberAnalysisService;
    }

    // Find Member by Type
    @CrossOrigin( origins = "http://localhost:3000" )
    @RequestMapping( value = "/memberAnalysis", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public ArrayList memberAnalysis(@RequestParam String type ) {
        return memberAnalysisService.getMemberAnalysis(type);
    }
}
