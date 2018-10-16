package com.example.server.controller;

import com.example.server.entity.Girl;
import com.example.server.object.ResultObject;
import com.example.server.utils.ResultUtils;
import com.example.server.repository.GirlRepository;
import com.example.server.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class GirlController {
    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    @GetMapping("/girls")
    public ResultObject getGirlList() throws Exception {
        return ResultUtils.success(girlService.getGirls());
    }

    @PostMapping("/girls")
    public ResultObject addGirl(Girl newGirl) throws Exception {
        Girl girl = girlService.createGirl(newGirl);
        return ResultUtils.success(girl);
    }

    @PutMapping("/girls")
    public ResultObject updateGirl(Girl newGirl) {
        Girl girl = new Girl();
        girl.setGirlId(newGirl.getGirlId());
        if (newGirl.getUsername() != null) {
            girl.setUsername(newGirl.getUsername());
        }
        if (newGirl.getAge() != null) {
            girl.setAge(newGirl.getAge());
        }
        return ResultUtils.success(girl);
    }

    @DeleteMapping("/girls/{id}")
    public void deleteGirl(@RequestParam("id") Integer id) {
        Girl girl = new Girl();
        girl.setGirlId(id);
        girlRepository.delete(girl);
    }

}
