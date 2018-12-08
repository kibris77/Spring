package ru.alexproger.student.entity;


import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Table(name = "Students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "secondName")
    private String secondName;

    @OneToOne (cascade=CascadeType.ALL)
    private Adress adress;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable (name="student_courses",
            joinColumns=@JoinColumn (name="student_id"),
            inverseJoinColumns=@JoinColumn(name="course_id"))
    private List<Course> courses = new ArrayList<>();

    public Student(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public Student(String firstName, String secondName, Adress adress, List<Course> courses) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.adress = adress;
        this.courses = courses;
    }
}
