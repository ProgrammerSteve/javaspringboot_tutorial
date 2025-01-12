package com.steven.example.student;

import com.steven.example.school.School;
import org.junit.jupiter.api.*;



class StudentMapperTest {

    private StudentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper=new StudentMapper();
    }

    @Test
    public void shouldMapDtoToStudent(){
        StudentDto dto = new StudentDto("John","Aguilar", "gatorpride52@gmail.com",1);
        Student student=mapper.toStudent(dto);

        Assertions.assertEquals(dto.firstname(),student.getFirstname());
        Assertions.assertEquals(dto.lastname(),student.getLastname());
        Assertions.assertEquals(dto.email(),student.getEmail());
        Assertions.assertNotNull(student.getSchool());
        Assertions.assertEquals(dto.schoolId(),student.getSchool().getId());
    }

    @Test
    public void should_throw_null_pointer_exception_when_studentDto_is_null(){
        var exp=Assertions.assertThrows(NullPointerException.class,()->mapper.toStudent(null));
        Assertions.assertEquals("The student Dto should not be null",exp.getMessage());
    }



    @Test
    public void shouldMapStudentToDto(){
        Student student = new Student("John","Aguilar","gatorpride52@gmail.com",20);

        StudentResponseDto dto=mapper.toStudentResponseDto(student);

        Assertions.assertEquals(dto.firstname(),student.getFirstname());
        Assertions.assertEquals(dto.lastname(),student.getLastname());
        Assertions.assertEquals(dto.email(),student.getEmail());
    }
}