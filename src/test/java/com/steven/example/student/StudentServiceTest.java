package com.steven.example.student;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepository repository;
    @Mock
    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /*
        public List<StudentResponseDto> findAllStudent(){
            return repository.findAll().stream().map(studentMapper::toStudentResponseDto).collect(Collectors.toList());
        }
    * */

    @Test
    public void should_return_all_students(){
        List<Student> students=new ArrayList<>();
        students.add(new Student("John","Aguilar","John@gmail.com",20));

        Mockito.when(repository.findAll()).thenReturn(students);
        Mockito.when(studentMapper.toStudentResponseDto(Mockito.any(Student.class)))
                .thenReturn(new StudentResponseDto("John","Aguilar","John@gmail.com"));

        List<StudentResponseDto> responseDtos=studentService.findAllStudent();
        Assertions.assertEquals(students.size(),responseDtos.size());

        Mockito.verify(repository,Mockito.times(1)).findAll();
    }

    @Test
    public  void should_sucessfully_save_a_student(){
        StudentDto dto=new StudentDto("John","Aguilar","john@gmail.com",1);
        Student student=new Student("John","Aguilar","john@gmail.com",20);
        Student savedStudent=new Student("John","Aguilar","john@gmail.com",20);
        savedStudent.setId(1);

        //Mock the calls
        Mockito.when(studentMapper.toStudent(dto)).thenReturn(student);
        Mockito.when(repository.save(student)).thenReturn(savedStudent);
        Mockito.when(studentMapper.toStudentResponseDto(savedStudent))
                .thenReturn(new StudentResponseDto("John","Aguilar","john@gmail.com"));

        StudentResponseDto responseDto=studentService.saveStudent(dto);

        Assertions.assertEquals(dto.firstname(),responseDto.firstname());
        Assertions.assertEquals(dto.lastname(),responseDto.lastname());
        Assertions.assertEquals(dto.email(),responseDto.email());

        Mockito.verify(studentMapper,Mockito.times(1))
                .toStudent(dto);
        Mockito.verify(repository,Mockito.times(1))
                .save(student);
        Mockito.verify(studentMapper,Mockito.times(1))
                .toStudentResponseDto(savedStudent);
    }

    @Test
    public void should_return_student_by_id(){
        int studentId=1;
        Student student=new Student("John","Aguilar","john@gmail.com",20);
        Mockito.when(repository.findById(studentId)).thenReturn(Optional.of(student));
        Mockito.when(studentMapper.toStudentResponseDto(Mockito.any(Student.class)))
                .thenReturn(new StudentResponseDto("John","Aguilar","john@gmail.com"));
        StudentResponseDto dto=studentService.findStudentById(studentId);
        Assertions.assertEquals(dto.firstname(),student.getFirstname());
        Assertions.assertEquals(dto.lastname(),student.getLastname());
        Assertions.assertEquals(dto.email(),student.getEmail());
        Mockito.verify(repository,Mockito.times(1)).findById(studentId);
    }

    @Test
    public void should_find_student_by_name(){
        List<Student> students=new ArrayList<>();
        String studentName="John";
        students.add(new Student("John","Aguilar","John@gmail.com",20));
        Mockito.when(repository.findAllByFirstnameContaining(studentName)).thenReturn(students);
        Mockito.when(studentMapper.toStudentResponseDto(Mockito.any(Student.class)))
                .thenReturn(new StudentResponseDto("John","Aguilar","John@gmail.com"));

        var responseDto=studentService.findStudentsByName(studentName);
        Assertions.assertEquals(students.size(),responseDto.size());
        Mockito.verify(repository,Mockito.times(1))
                .findAllByFirstnameContaining(studentName);

    }
}