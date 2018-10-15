package com.example.server.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/param")
public class ParamController {

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String product(@PathVariable("name") String name) {
        return "Product:" + name;
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String category(@RequestParam(value = "name", required = false, defaultValue = "All") String name) {
        return "Category:" + name;
    }
}
