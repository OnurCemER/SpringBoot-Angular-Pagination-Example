package com.spring.springdemo.Business;

import com.spring.springdemo.Entities.City;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICityService {
    List<City> getAll();
    void add(City city);
    void update(City city);
    void delete(City city);
    City getById(Long id);
//    Page<City> getAllPagination(int page);
}
