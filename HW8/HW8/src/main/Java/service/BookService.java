package service;

import entity.Book;

public class BookService extends Book {
    public BookService() {
    }

    public  void addBook(String title, String printYear, int authorId) {
        super.setTitle(title);
        super.setPrintYear(printYear);
        super.setAuthorId(authorId);
    }
}
