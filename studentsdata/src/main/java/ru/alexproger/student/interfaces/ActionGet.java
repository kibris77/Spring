package ru.alexproger.student.interfaces;

import org.hibernate.Session;

import java.util.List;

public interface ActionGet<T> {
    List<T> executeGet(Session session);
}
