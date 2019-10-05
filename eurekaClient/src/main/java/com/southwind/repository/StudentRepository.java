package com.southwind.repository;

import com.southwind.entity.Student;

import java.util.Collection;

public interface StudentRepository {
    public Collection<Student> FinfAll();

    public  Student  byId(Long id);

    public void saveOrUpdate(Student student);
    public void deleteById(long id);
}
