package kz.narxoz.argo.repository;

import kz.narxoz.argo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Long> {



}
