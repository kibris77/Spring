package ru.alexproger.student.dao;

import ru.alexproger.student.entity.Student;

public class StudentDAO extends AbstractDAO<Student> {
    private static final StudentDAO INSTANCE = new StudentDAO();

    public static StudentDAO getInstance() {
        return INSTANCE;
    }
}
