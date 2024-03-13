package com.jpa.repository;

import com.jpa.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    public List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);



    List<Student> findByLastNameNotNull ();

    List<Student> findByguardianName(String Guardian) ;

    Student findByFirstNameAndLastName(String firstName,String lastName);

    //JPQl Queries
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailId(String email) ;

    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailId (String emailId) ;

    /*
    * Native Query
    * */

    @Query(
            value = "select * from std_dtl s where s.email_id = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailIdNative (String email) ;

    // native Named Param
    @Query(
            value = "select * from std_dtl s where s.email_id = :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailIdNativeNamedParam (@Param("emailId") String emailId) ;

    @Modifying
    @Transactional
    @Query(
            value = "update std_dtl set first_name =?1 where email_id = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId (String firstName,String emailId) ;

}
