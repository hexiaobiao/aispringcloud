package com.southwind.controller;

import com.southwind.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/ribbon")
public class RibbonContrller {
    @Autowired
    private RestTemplate restTemplate;


    @GetMapping ("/findAll")
    public Collection<Student> findAll(){
        return restTemplate.getForEntity("http://provider/student/findAll",Collection.class).getBody();

    }
    @GetMapping("/findAll2/{id}")
    public  Student finfByid(@PathVariable ("id") long id){

        return restTemplate.getForObject("http://provider/student/findAll/{id}",Student.class,id);
    }

    @PostMapping ("/save")
    public  void  save(@RequestBody Student student){
        restTemplate.postForEntity("http://provider/student",Student.class,null).getBody();
    }
    @PostMapping ("/save2")
    public  void  save2(@RequestBody Student student){
        restTemplate.postForObject("http://provider/student",Student.class,null);
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student){
        restTemplate.put("http://provider/student/update",Student.class);
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        restTemplate.delete("http://provider/student/{id}",id);
    }
    @GetMapping("/index")
    public String index(){
        return
                restTemplate.getForObject("http://provider/student/index",String.class);
    }

}
