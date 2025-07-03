package com.example.springdatajpa.repository;

import com.example.springdatajpa.entity.Guardian;
import com.example.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .firstName("test3")
                .lastName("testL3")
                .emailId("EmailT3")
//                .guardianName("guard3")
//                .guardianEmail("gEmail3")
//                .guardianMobile("1234563")
                .build();

        Student savedStudent = studentRepository.save(student);

    }

    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .name("guard4")
                .email("gEmail4")
                .mobile("12345634")
                .build();

        Student student = Student.builder()
                .firstName("test4")
                .lastName("testL4")
                .emailId("EmailT4")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents() {
        List<Student> students = studentRepository.findAll();
        System.out.println("Student List:" + students);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("test4");
        System.out.println("Student List:" + students);
    }

    @Test
    public void getStudentByEmailId(){
        Student student = studentRepository.getStudentByEmailId("EmailT4");
        System.out.println("Student:" + student);
    }

    @Test
    public void getStudentFirstNameByEmailId(){
        String firstName = studentRepository.getStudentFirstNameByEmailId("EmailT4");
        System.out.println("Student:" + firstName);
    }

    @Test
    void getStudentFirstNameByEmailIdNative(){
        String firstName = studentRepository.getStudentFirstNameByEmailIdNative("EmailT4");
        System.out.println("Student:" + firstName);
    }

    @Test
    void getStudentFirstNameByEmailIdNativeNamedparam(){
        String firstName = studentRepository.getStudentFirstNameByEmailIdNativeNamedparam("EmailT4");
        System.out.println("Student:" + firstName);
    }

    @Test
    void updateStudentFirstNameByEmailId(){
        studentRepository.updateStudentFirstNameByEmailId("EmailT4", "UpdatedFirstName");
    }
}