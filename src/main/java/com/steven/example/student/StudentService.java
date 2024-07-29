package com.steven.example.student;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository repository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }
    public StudentResponseDto saveStudent(StudentDto dto){
        var student=studentMapper.toStudent(dto); //turn StudentDto Record into Student
        var savedStudent=repository.save(student);//Get Student from repository
        return studentMapper.toStudentResponseDto(savedStudent);//Turn Student into StudentResponseDto Record
    }
    public List<StudentResponseDto> findAllStudent(){
        return repository.findAll().stream().map(studentMapper::toStudentResponseDto).collect(Collectors.toList());
    }
    public StudentResponseDto findStudentById(int id){
        return repository.findById(id).map(studentMapper::toStudentResponseDto).orElse(null);
        //return studentMapper.toStudentResponseDto(repository.findById(id).orElse(new Student()));
    }
    public List<StudentResponseDto> findStudentsByName(String name){
        return repository.findAllByFirstnameContaining(name).stream().map(studentMapper::toStudentResponseDto).collect(Collectors.toList());
    }
    public void deleteStudentById(int id){
        repository.deleteById(id);
    }
}
