package kz.narxoz.argo.service;

import kz.narxoz.argo.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> findAllBook();

    Book saveBook(Book book);

    Book findBook(Long id);

    void deleteBook(Long id);
}
