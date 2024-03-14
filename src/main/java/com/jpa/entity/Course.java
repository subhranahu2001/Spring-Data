package com.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "course_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long courseId;
    private String title;
    private Integer credit;

    @OneToOne(mappedBy = "course")
    private CourseMaterial material;


    /*
    * Many Course are related to the one teacher.
    * */
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "teacher_Student_table",
            joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "courseId"),
            inverseJoinColumns = @JoinColumn(name = "stud_id", referencedColumnName = "studentId")
    )
    private List<Student> students;

    public void addStudent(Student student) {
        if (students == null) students = new ArrayList<Student>();
        students.add(student);
    }
}
