package ru.alexproger.hibertest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.alexproger.hibertest.entity.Author;
import ru.alexproger.hibertest.entity.Author_;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import java.util.List;

public class AuthorHelper {
    private final SessionFactory sessionFactory;

    public AuthorHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<Author> getAuthorList() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Author.class);
        Root<Author> root = cq.from(Author.class);
        Selection[] selections = {root.get(Author_.id), root.get(Author_.secondName)};
        cq.select(cb.construct(Author.class, selections));
        Query query = session.createQuery(cq);
        List<Author> result = query.getResultList();
        return result;
    }

    public Author addAuthor(Author author) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        for (int i = 0; i < 200; i++) {
            if (i % 20 == 0) {
                session.flush();
            }
            Author newAuthor = new Author("name" + i);
            session.save(newAuthor);
        }
        session.getTransaction().commit();
        session.close();
        return author;
    }
}
