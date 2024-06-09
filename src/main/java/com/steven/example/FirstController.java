package com.steven.example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FirstController {

    private final StudentRepository respository;

    public FirstController(StudentRepository respository) {
        this.respository = respository;
    }

    @PostMapping("/students")
    public Student post(
            @RequestBody Student student
    ){
        return respository.save(student);
    }

    @GetMapping("/students")
    public List<Student>  findAllStudent(){
        return respository.findAll();
    }

    @GetMapping("/students/{student-id}")
    public Student findStudentById(
            @PathVariable("student-id")int id
    ){
        return respository.findById(id).orElse(new Student());
    }


    @GetMapping("/students/search/{student-name}")
    public List<Student> findStudentsByName(
            @PathVariable("student-name")String name
    ){
        return respository.findAllByFirstnameContaining(name);
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentById(
            @PathVariable("student-id")int id
    ){
        respository.deleteById(id);
    }



}
