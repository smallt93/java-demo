package com.example.team2.controller;

import com.example.team2.model.House;
import com.example.team2.service.HouseService;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileReader;
import java.io.IOException;

@RestController
public class HelloController {

    @Autowired
    private HouseService houseService;

    @GetMapping("/house")
    public House getHouse() {
        return houseService.getHouse();
    }

    @GetMapping("/houses")
    public JSONArray getHouses(@RequestBody(required = false) LoginParams params) {

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("D:/users.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray employeeList = (JSONArray) obj;

            if (params == null || params.userName.isEmpty()) {
                return null;
            }
            return employeeList;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}

class LoginParams {
    public String userName;
    public String password;
}

