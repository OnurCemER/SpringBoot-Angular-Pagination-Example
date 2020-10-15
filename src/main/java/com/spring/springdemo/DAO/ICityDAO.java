package com.spring.springdemo.DAO;

import com.spring.springdemo.Entities.City;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICityDAO {
    List<City> getAll();
    void add(City city);
    void update(City city);
    void delete(City city);
    City getById(Long id);
}
