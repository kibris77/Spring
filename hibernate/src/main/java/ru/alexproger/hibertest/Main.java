package ru.alexproger.hibertest;

import org.jboss.logging.Logger;
import ru.alexproger.hibertest.entity.Author;
import ru.alexproger.hibertest.entity.Book;

import java.util.List;

public class Main {
    private static final Logger LOG = Logger.getLogger(AuthorHelper.class.getName());

    public static void main(String[] args) {
        AuthorHelper authorHelper = new AuthorHelper();
        BookHelper bookHelper = new BookHelper();

       /* Author newAuthor = new Author("Земцов");
        authorHelper.addAuthor(newAuthor);

        for (Author author: authorHelper.getAuthorList()) {
            LOG.warn(author.getName());
        }
        for (Book book: bookHelper.getBookList()) {
            LOG.warn(book.getName());
        }*/
        List<Author> list = authorHelper.getAuthorList();
        System.out.println(list);

        HibernateUtil.close();
    }
}
