package ru.alexproger.student.dao;

import ru.alexproger.student.entity.Adress;

public class AdressDAO extends AbstractDAO<Adress> {
    private static final AdressDAO INSTANCE = new AdressDAO();

    public static AdressDAO getInstance() {
        return INSTANCE;
    }
}
