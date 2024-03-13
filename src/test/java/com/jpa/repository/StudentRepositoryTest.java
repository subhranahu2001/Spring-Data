package com.jpa.repository;

import com.jpa.entity.Guardian;
import com.jpa.entity.Student;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository repository;

    @Test
    public void saveStudent () {
        Student student = Student.builder()
                .firstName("Thor")
                .lastName("Odain")
                .emailId("Thor@gmail.com")
                .build();

        repository.save(student);
    }


    @Test
    public void getStudent() {
        repository.findAll().forEach(System.out::println);

    }

    @Test
    public void saveStudentWithGuardian () {
        Guardian guardian = Guardian.builder()
                .name("Umakanta")
                .email("uma@gmail.com")
                .mobile("123456")
                .build();
        Student student = Student.builder()
                .firstName("lilu")
                .lastName("barik")
                .emailId("lilu@gmail.com")
                .guardian(guardian)
                .build();
        repository.save(student);

    }

    @Test
    public void printStudentByFirstName () {
        List<Student> students = repository.findByFirstName("silu");
        System.out.println(students);

    }

    @Test
    public void printStudentByFirstNameContaining () {
        List<Student> students = repository.findByFirstNameContaining("th");
        System.out.println(students);

    }

//    @Test
//    public void printStudentBasedOnGuardianName() {
//        List<Student> students = repository.findByGuardianName("umakanta");
//        System.out.println(students);
//    }
//
    @Test
    public void printStudentBasedOnLastNameNotNull () {
        List<Student> list = repository.findByLastNameNotNull();
        list.forEach(System.out::println);
    }

    @Test
    public void printStudentByGuardianName () {
        List<Student> list = repository.findByguardianName("umakanta");
        System.out.println(list);
    }

    @Test
    public void printStudentByFirstNameAndLastName () {
      Student s = repository.findByFirstNameAndLastName("silu","barik");
        System.out.println(s);
    }
    @Test
    public void printStudentByEmailId() {
        Student s = repository.getStudentByEmailId("lilu@gmail.com");
        System.out.println(s);
    }

    @Test
    public void printStudentFirstNameByEmailId () {
        String s = repository.getStudentFirstNameByEmailId("silu@gmail.com");
        System.out.println(s);
    }
    @Test
    public void printStudentByEmailIdNative () {
        Student student = repository.getStudentByEmailIdNative("Thor@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printStudentByEmailIdNativeNamedParam() {
        Student s = repository.getStudentByEmailIdNativeNamedParam("lilu@gmail.com");
        System.out.println(s);
    }

    @Test
    public void updateStudentNameByEmailId() {
       int update = repository.updateStudentNameByEmailId("subhranshu","silu@gmail.com");
        System.out.println(update+" row is updated");
    }



}