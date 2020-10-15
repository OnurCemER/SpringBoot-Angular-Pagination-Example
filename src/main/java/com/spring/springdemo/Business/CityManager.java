package com.spring.springdemo.Business;

import com.spring.springdemo.DAO.ICityDAO;
import com.spring.springdemo.Entities.City;
import com.spring.springdemo.Repo.ICityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityManager implements ICityService {

    private ICityDAO cityDAO;
    private final ICityRepo cityRepo;

    @Autowired
    public CityManager(ICityDAO cityDAO, ICityRepo cityRepo) {
        this.cityDAO = cityDAO;
        this.cityRepo = cityRepo;
    }

    @Override
    @Transactional
    public List<City> getAll() {
        return this.cityDAO.getAll();
    }

    @Override
    @Transactional
    public void add(City city) {
        this.cityDAO.add(city);
    }

    @Override
    @Transactional
    public void update(City city) {
        this.cityDAO.update(city);
    }

    @Override
    @Transactional
    public void delete(City city) {
        this.cityDAO.delete(city);
    }

    @Override
    @Transactional
    public City getById(Long id) {

        return this.cityDAO.getById(id);
    }

//    @Override
//    public Page<City> getAllPagination(int page) {
//        return cityRepo.findAll(PageRequest.of(page,4));
//    }
}
