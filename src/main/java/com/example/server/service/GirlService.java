package com.example.server.service;

import com.example.server.entity.Girl;
import com.example.server.enums.CodeEnum;
import com.example.server.exception.GirlException;
import com.example.server.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    public List<Girl> getGirls() throws Exception {
        List<Girl> girls = girlRepository.findAll();
        if (girls.isEmpty()) {
            throw new GirlException(CodeEnum.DATA_EMPTY);
        }
        return  girls;
    }

    public Girl createGirl(Girl newGirl) {
        Integer age = newGirl.getAge();
        String username = newGirl.getUsername();
        if (age < 18) {
            throw new GirlException(CodeEnum.DENY_18_AGE);
        }
        if (username.length() > 6) {
            throw new GirlException(CodeEnum.USER_LENGTH);
        }
        Girl existsGirl = girlRepository.getGirlByUsername(username);
        if (existsGirl != null) {
            throw new GirlException(CodeEnum.USER_EXISTS);
        }

        Girl girl = new Girl();
        girl.setAge(age);
        girl.setUsername(newGirl.getUsername());
        return girlRepository.save(girl);
    }
}
