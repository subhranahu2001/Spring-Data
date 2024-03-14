package com.jpa.repository;

import com.jpa.entity.Course;
import com.jpa.entity.Student;
import com.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository repository;

    @Test
    public void printCourses() {
        List<Course> list = repository.findAll();
        System.out.println(list);

    }

    @Test
    public void saveCourseWithTeacher() {

        Teacher teacher = Teacher.builder()
                .firstName("JianhuaDin")
                .lastName("Jian")
                .build();

        Course course = Course.builder()
                .title("python")
                .credit(4)
                .teacher(teacher)
                .build();
        Course course2 = Course.builder()
                .title("NetWork")
                .credit(3)
                .teacher(teacher)
                .build();
        Course course3 = Course.builder()
                .title("SpringBoot")
                .credit(8)
                .teacher(teacher)
                .build();
//        repository.save(course);
        repository.save(course2);
//        repository.save(course3);
    }

    /*
    * Pagination
    * */
    @Test
    public void findAllPagination () {
        Pageable firstPageWithThreeRecords = PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1,2);

        List<Course> courses = repository.findAll(secondPageWithTwoRecords).getContent();

        Long totalElements = repository.findAll(secondPageWithTwoRecords).getTotalElements();

        int totalPages = repository.findAll(secondPageWithTwoRecords).getTotalPages();
        System.out.println("Total pages: " + totalPages);
        System.out.println("Total elements: " + totalElements);
        System.out.println("courses: " + courses);

    }
    @Test
    public void findAllWithSorting() {
        Pageable sortByTitle = PageRequest.of(0,3, Sort.by("title"));

        Pageable sortByCreditDesc = PageRequest.of(0,3, Sort.by("credit").descending());

        Pageable sortByTitleAndCredit = PageRequest.of(0,3, Sort.by("title").descending().and(Sort.by("credit")));

        List<Course> courses = repository.findAll(sortByTitleAndCredit).getContent();
        courses.forEach(System.out::println);
    }
    @Test
    public void printFindByTitleContaining() {
        Pageable firstPageFRecords = PageRequest.of(0,10);
        List<Course> courses = repository.findByTitleContaining("D",firstPageFRecords).getContent();

        System.out.println("course"+courses);
    }
    @Test
    public void saveCourseWithStudentAndTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("LinhJones")
                .lastName("XiaopingIto")
                .build();
        Student student = Student.builder()
                .firstName("Satya")
                .lastName("sahoo")
                .emailId("satya@gmail.com")
                .build();

        Course course = Course.builder()
                .teacher(teacher)
                .title("AI")
                .credit(7)
                .build();
        course.addStudent(student);
        repository.save(course);
    }

}