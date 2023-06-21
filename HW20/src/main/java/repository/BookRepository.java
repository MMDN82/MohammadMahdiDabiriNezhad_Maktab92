package repository;

import base.repository.BaseRepository;
import entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends BaseRepository<Book,Long> {
    Optional<Book> searchByBook(Book book);
    List<Book> booksNotHaveIssue();
    String searchWithIssue(String issue);
}
