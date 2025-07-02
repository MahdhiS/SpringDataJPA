package com.example.springdatajpa.repository;

import com.example.springdatajpa.entity.Guardian;
import com.example.springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

     List<Student> findByFirstName(String firstName);

//    List<Student> findByGuardian(Guardian guardian);


    //JPQL
    @Query("select s from Student s where s.emailId = ?1")   // ?1 means first parameter passed in function ie String emailId
    Student getStudentByEmailId(String emailId);

    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailId(String emailId);


    //Native Queries
    @Query(
            value ="SELECT * FROM tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    String getStudentFirstNameByEmailIdNative(String emailId);

    //Native Queries with named paramethers
    @Query(
            value ="SELECT * FROM tbl_student s where s.email_address = :emailId",
            nativeQuery = true
    )
    String getStudentFirstNameByEmailIdNativeNamedparam(@Param("emailId") String emailId);


}
