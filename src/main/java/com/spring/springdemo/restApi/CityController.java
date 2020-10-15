package com.spring.springdemo.restApi;

import com.spring.springdemo.Business.ICityService;
import com.spring.springdemo.Entities.City;
import com.spring.springdemo.Repo.ICityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class CityController {
    private ICityService cityService;
    private final ICityRepo cityRepo;

    @Autowired
    public CityController(ICityService cityService, ICityRepo cityRepo) {
        this.cityService = cityService;
        this.cityRepo = cityRepo;
    }

    @GetMapping("/cities")
    public List<City> get(){
        return cityService.getAll();
    }

    @GetMapping("/pagination")
    public Page<City> getAllPagination(@RequestParam(defaultValue = "0") int page){
        return cityRepo.findAll(PageRequest.of(page,4));
    }

    @PostMapping("/add")
    public void add(@RequestBody City city){
        cityService.add(city);
    }

    @PostMapping("/update")
    public void update(@RequestBody City city){
        cityService.update(city);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody City city){
        cityService.delete(city);
    }

    @GetMapping("/cities/{id}")
    public City getById(@PathVariable Long id){
        return cityService.getById(id);
    }
}
