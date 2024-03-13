package com.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "std_dtl",
        uniqueConstraints = @UniqueConstraint(
                name = "emailId_unique",
                columnNames = "emailId"
        )
)
public class Student {


    @Id
    @SequenceGenerator(
            name = "student-sequence",
            sequenceName = "student-sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student-sequence"
    )
    private Long studentId;
    private String firstName;
    private String lastName;

    @Column(nullable = false)
    private String emailId;

    @Embedded
    private Guardian guardian;


}
