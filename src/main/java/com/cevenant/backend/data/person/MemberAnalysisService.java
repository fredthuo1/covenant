package com.cevenant.backend.data.person;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberAnalysisService {

    final PersonRepo personRepo;

    public MemberAnalysisService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public ArrayList<Person> getMemberAnalysis(String type) {
        List<Person> personList = personRepo.findAll();
        ArrayList<Person> people = new ArrayList<>();

        System.out.println(type);
        String finalType = type;

        personList.forEach(person -> {
            try {
                if (person.getMemberType().equals(finalType)) {
                    people.add(person);
                }
            }
            catch ( NullPointerException e ) {
            }
        });

        return people;
    }
}
