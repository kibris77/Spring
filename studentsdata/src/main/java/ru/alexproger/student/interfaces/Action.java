package ru.alexproger.student.interfaces;

import org.hibernate.Session;

public interface Action<T> {
    void execute(Session session);
}
