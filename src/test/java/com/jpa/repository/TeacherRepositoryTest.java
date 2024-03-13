package com.jpa.repository;

import com.jpa.entity.Course;
import com.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher () {
        Course courseJava = Course.builder()
                .title("DBA")
                .credit(5)
                .build();
        Course courseDBA = Course.builder()
                .title("Java")
                .credit(6)
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("Durga")
                .lastName("Barik")
                .courses(List.of(courseDBA,courseJava))
                .build();

        teacherRepository.save(teacher);
    }
}