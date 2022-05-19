package kz.narxoz.argo.controller;

import kz.narxoz.argo.entity.Book;
import kz.narxoz.argo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/book")
    public String viewBooks(Model model){
        model.addAttribute("books", bookService.findAllBook());
        return "books";
    }

    @GetMapping("/book/new")
    public String addBookForm(Model model){
        Book book = new Book();
        model.addAttribute("book", book);
        return "add_book";
    }

    @PostMapping("/book/add")
    public String saveBook(@ModelAttribute("book") Book book){
        bookService.saveBook(book);
        return "redirect:/book";
    }

    @GetMapping("/book/update/{id}")
    public String updateBookForm(Model model, @PathVariable("id") Long id){
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "update_book";
    }

    @PostMapping("/book/change/{id}")
    public String updateBook(@PathVariable("id") Long id, @ModelAttribute("book") Book book){
        Book myBook = bookService.findBook(id);
        myBook = book;
        bookService.saveBook(myBook);
        return "redirect:/book";
    }

    @GetMapping("/book/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/book";
    }

}
