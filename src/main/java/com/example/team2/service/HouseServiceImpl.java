package com.example.team2.service;

import com.example.team2.model.House;
import org.springframework.stereotype.Component;

@Component
public class HouseServiceImpl implements HouseService {
    @Override
    public House getHouse() {
        return new House(1, "Bitexco", 56);
    }
}
