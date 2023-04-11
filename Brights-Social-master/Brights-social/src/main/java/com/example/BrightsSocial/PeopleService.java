package com.example.BrightsSocial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeopleService {

    @Autowired
    PeopleRepository peopleRepository;

    List<People> getAllPeople(){
        List<People> allPeople = (List<People>) peopleRepository.findAll();
        return allPeople;
    }

    void savePeople(People people){
        peopleRepository.save(people);
    }

    People findUser(String username){
        People people = peopleRepository.findByUsername(username);
        return people;
    }

    String getUserNameById(long id){
        String username = getUserNameById(id);
        return username;
    }

    List<People> getOtherPeople(String username){
        List<People> usersToShow = new ArrayList<>();
        List<People> allPeople = getAllPeople();
        for (People people : allPeople) {
            if (!people.getUsername().equals(username)) {
                usersToShow.add(people);
            }
        }
        return usersToShow;
    }
}
