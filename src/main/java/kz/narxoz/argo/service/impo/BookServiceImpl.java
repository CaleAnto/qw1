package kz.narxoz.argo.service.impo;

import kz.narxoz.argo.entity.Book;
import kz.narxoz.argo.repository.BookRepository;
import kz.narxoz.argo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> findAllBook(){
        return bookRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    @Override
    public Book findBook(Long id){
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

}
