package com.southwind.repository.impl;

import com.southwind.entity.Student;
import com.southwind.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private  static Map<Long,Student> studentMap;

    static {
        studentMap=new HashMap<>();
        studentMap.put(1L,new Student(1L,"hebiao",20));
        studentMap.put(2L,new Student(2L,"hehw",17));
        studentMap.put(3L,new Student(3L,"jeqj",18));
    }
    @Override
    public Collection<Student> FinfAll() {
        return studentMap.values();
    }

    @Override
    public Student byId(Long id) {
        return studentMap.get(id);
    }

    @Override
    public void saveOrUpdate(Student student) {
     studentMap.put(student.getId(),student);
    }

    @Override
    public void deleteById(long id) {
      studentMap.remove(id);
    }
}
