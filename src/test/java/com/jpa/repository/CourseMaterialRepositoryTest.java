package com.jpa.repository;

import com.jpa.entity.Course;
import com.jpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository materialRepository;

    @Test
    public void saveCourseMaterial() {
        Course course = Course.builder()
                .title("DSA")
                .credit(6)
                .build();
        CourseMaterial material = CourseMaterial.builder()
                .url("www.google.com")
                .course(course)
                .build();

        materialRepository.save(material);
    }
    @Test
    public void getAllCourseMaterial () {
        List<CourseMaterial> list = materialRepository.findAll();
        System.out.println(list);
    }

}