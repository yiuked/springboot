package com.example.server.controller;

import com.example.server.entity.Girl;
import com.example.server.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @GetMapping("/girls")
    public List<Girl> getGirlList() {
        return girlRepository.findAll();
    }

    @PostMapping("/girls")
    public Girl addGirl(Girl newGirl) {
        Girl girl = new Girl();
        girl.setAge(newGirl.getAge());
        girl.setUsername(newGirl.getUsername());
        return girlRepository.save(girl);
    }

    @PutMapping("/girls")
    public Girl updateGirl(Girl newGirl) {
        Girl girl = new Girl();
        girl.setGirlId(newGirl.getGirlId());
        if (newGirl.getUsername() != null) {
            girl.setUsername(newGirl.getUsername());
        }
        if (newGirl.getAge() != null) {
            girl.setAge(newGirl.getAge());
        }
        return girlRepository.save(girl);
    }

    @DeleteMapping("/girls/{id}")
    public void deleteGirl(@RequestParam("id") Integer id) {
        Girl girl = new Girl();
        girl.setGirlId(id);
        girlRepository.delete(girl);
    }

}
