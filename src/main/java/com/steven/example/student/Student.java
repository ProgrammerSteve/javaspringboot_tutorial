package com.steven.example.student;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import com.steven.example.school.School;
import com.steven.example.studentprofile.StudentProfile;

@Entity
@Table(name="T_STUDENT")
public class Student {
    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @ManyToOne
    @JoinColumn(
            name = "school_id"
    )
    @JsonBackReference
    private School school;


    @OneToOne(mappedBy = "student",
        cascade = CascadeType.ALL)
    private StudentProfile studentProfile;

    @Id
    @GeneratedValue
    private Integer id;

    @Column(
            name="c_fname",
            length = 20
    )
    private String firstname;
    private String lastname;

    @Column(
            unique = true
    )
    private String email;
    private int age;

    @Column(updatable = false)
    private String some_column;


    public Student() {
    }

    public Student(String firstname, String lastname, String email, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
