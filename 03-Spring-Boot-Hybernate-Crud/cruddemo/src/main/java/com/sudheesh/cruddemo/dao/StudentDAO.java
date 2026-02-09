package com.sudheesh.cruddemo.dao;

import com.sudheesh.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student student);

    Student findById(Integer id);
}
