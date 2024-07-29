package com.steven.example.student;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService=studentService;
    }
    @PostMapping("/students")
    public StudentResponseDto saveStudent(
            @RequestBody StudentDto dto
    ){
        return studentService.saveStudent(dto);
    }
    @GetMapping("/students")
    public List<StudentResponseDto>  findAllStudent(){
        return studentService.findAllStudent();
    }
    @GetMapping("/students/{student-id}")
    public StudentResponseDto findStudentById(@PathVariable("student-id")int id){
        return studentService.findStudentById(id);
    }
    @GetMapping("/students/search/{student-name}")
    public List<StudentResponseDto> findStudentsByName(@PathVariable("student-name")String name){
        return studentService.findStudentsByName(name);
    }
    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentById(@PathVariable("student-id")int id){
        studentService.deleteStudentById(id);
    }
}
