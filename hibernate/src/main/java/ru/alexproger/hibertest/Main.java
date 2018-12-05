package ru.alexproger.hibertest;

import org.jboss.logging.Logger;
import ru.alexproger.hibertest.entity.Author;
import ru.alexproger.hibertest.entity.Book;

public class Main {
    private final Logger logger = Logger.getLogger(AuthorHelper.class.getName());

    public static void main(String[] args) {
        AuthorHelper authorHelper = new AuthorHelper();
        BookHelper bookHelper = new BookHelper();
        for (Author author: authorHelper.getAuthorList()) {
            System.out.println(author.getName());
        }
        for (Book book: bookHelper.getBookList()) {
            System.out.println(book.getName());
        }
        HibernateUtil.close();
    }
}
