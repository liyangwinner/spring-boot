package com.liyang.repository;

import com.liyang.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    public List<Student> getByName(String name);
}
