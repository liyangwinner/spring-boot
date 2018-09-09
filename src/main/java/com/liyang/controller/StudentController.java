package com.liyang.controller;

import com.liyang.entity.Student;
import com.liyang.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping("/getAllStudent")
    public List<Student> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        return students;
    }

    @PostMapping("/addStudent")
    public Student addStudent(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        Student student = new Student();
//        student.setId(id);
        student.setName(name);
        student.setAge(age);
        return studentRepository.save(student);
    }

    @GetMapping("/getStudent/{id}")
    public Student getStudentById(@PathVariable("id") Integer id) {
        Student student = studentRepository.getOne(id);
        System.out.println("name ：" + student.getName());
        return studentRepository.getOne(id);
    }
}
