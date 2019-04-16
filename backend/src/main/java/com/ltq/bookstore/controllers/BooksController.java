package com.ltq.bookstore.controllers;

import javax.validation.Valid;
import com.ltq.bookstore.models.Book;
import com.ltq.bookstore.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class BooksController {

    @Autowired
    BookRepository booksRepository;

    // Get all books from database.
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
        return booksRepository.findAll(sortByCreatedAtDesc);
    }

    // Save new book to database
    @PostMapping("/books")
    public Book createBook(@Valid @RequestBody Book book) {
        return booksRepository.save(book);
    }

    // Get book by ID.
    @GetMapping(value = "/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") String id) {
        return booksRepository.findById(id).map(book -> ResponseEntity.ok().body(book))
                .orElse(ResponseEntity.notFound().build());
    }

    // Update book by ID.
    @PutMapping(value = "/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") String id, @Valid @RequestBody Book book) {
        return booksRepository.findById(id).map(bookData -> {
            bookData.setTitle(book.getTitle());
            bookData.setImageSrc(book.getImageSrc());
            bookData.setAuthor(book.getAuthor());
            bookData.setPrice(book.getPrice());
            bookData.setRating(book.getRating());
            Book updatedBook = booksRepository.save(bookData);
            return ResponseEntity.ok().body(updatedBook);
        }).orElse(ResponseEntity.notFound().build());
    }

    // Delete book by ID.
    @DeleteMapping(value = "/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") String id) {
        return booksRepository.findById(id).map(book -> {
            booksRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}