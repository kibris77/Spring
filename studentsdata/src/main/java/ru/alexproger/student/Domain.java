package ru.alexproger.student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.alexproger.student.dao.StudentDAO;
import ru.alexproger.student.entity.Adress;
import ru.alexproger.student.entity.Course;
import ru.alexproger.student.entity.Student;
import ru.alexproger.student.util.HibernateUtil;

import java.util.List;

public class Domain {
    public static void main(String[] args) {
        Student student = new Student("Ivan", "Ivanov");
        Adress adress = new Adress("Pushkinskaya", 87);
        Course course = new Course("CompSciense");
        student.setAdress(adress);
        adress.setStudent(student);
        student.getCourses().add(course);
        course.getStudents().add(student);
        StudentDAO studentDAO = StudentDAO.getInstance();
        Student student1 = studentDAO.get(5L);
        HibernateUtil.close();

    }
}
