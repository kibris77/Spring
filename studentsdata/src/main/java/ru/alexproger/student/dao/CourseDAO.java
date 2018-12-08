package ru.alexproger.student.dao;

import ru.alexproger.student.entity.Course;

public class CourseDAO extends AbstractDAO<Course> {
    private static final CourseDAO INSTANCE = new CourseDAO();

    public static CourseDAO getInstance() {
        return INSTANCE;
    }
}
