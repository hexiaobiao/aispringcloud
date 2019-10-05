package com.southwind.controller;

import com.southwind.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/rest")
public class RestHandler {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping ("/findAll")
    public Collection<Student> findAll(){
        return restTemplate.getForEntity("http://127.0.0.1:8010/student/findAll",Collection.class).getBody();

    }
    @GetMapping("/findAll2/{id}")
    public  Student finfByid(@PathVariable ("id") long id){

         return restTemplate.getForObject("http://127.0.0.1:8010/student/findAll/{id}",Student.class,id);
    }

    @PostMapping ("/save")
    public  void  save(@RequestBody Student student){
        restTemplate.postForEntity("http://127.0.0.1:8010/student",Student.class,null).getBody();
    }
    @PostMapping ("/save2")
    public  void  save2(@RequestBody Student student){
        restTemplate.postForObject("http://127.0.0.1:8010/student",Student.class,null);
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student){
        restTemplate.put("http://127.0.0.1:8010/student/update",Student.class);
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
       restTemplate.delete("http://127.0.0.1:8010/student/{id}",id);
    }
}
