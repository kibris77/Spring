package ru.alexproger.student.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.alexproger.student.interfaces.Action;
import ru.alexproger.student.interfaces.ActionGet;
import ru.alexproger.student.util.HibernateUtil;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractDAO<T> {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractDAO.class);

    @SuppressWarnings("unchecked")
    private Class<T> tClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    private void persist(Action action) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            action.execute(session);
            transaction.commit();
        } catch (HibernateException he) {
            LOG.error(he.getMessage(), he);
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public List<T> persistGetAll(ActionGet action) {
        Transaction transaction = null;
        List<T> list = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            list = action.executeGet(session);
            transaction.commit();
        } catch (HibernateException he) {
            LOG.error(he.getMessage(), he);
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return list;
    }

    public void save(T t) {
        persist(session -> session.save(t));
    }

    public void update(T t) {
        persist(session -> session.update(t));
    }

    public void delete(T t) {
        persist(session -> session.delete(t));
    }


    public T get(long id) {
        return persistGetAll(session -> Collections.singletonList(session.get(tClass, id))).get(0);
    }

    public List<T> getAll() {
        return persistGetAll(session -> session.createQuery("from " + tClass.getSimpleName()).list());
    }
}
