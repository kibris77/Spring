package ru.alexproger.hibertest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.alexproger.hibertest.entity.Book;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class BookHelper {
    private final SessionFactory sessionFactory;

    public BookHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Book> getBookList() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Book.class);
        Root<Book> root = cq.from(Book.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        List<Book> result = query.getResultList();
        return result;
    }
}
