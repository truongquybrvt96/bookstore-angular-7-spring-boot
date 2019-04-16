import { Component, Input, OnInit } from '@angular/core';
import { BookService } from './books.service';
import { Book } from './book';
import { NgForm } from '@angular/forms';
import { NgbModal, NgbModalOptions } from '@ng-bootstrap/ng-bootstrap';
import { CreateModalComponent } from './create-modal/create-modal.component';


const ngbModalOptions: NgbModalOptions = {
  backdrop: 'static',
  keyboard: false
};
@Component({
  selector: 'book-app',
  templateUrl: './books.component.html'
})

export class BooksComponent implements OnInit {
  books: Book[] = [];
  newBook: Book = new Book();

  constructor(
    private bookService: BookService,
    private modalService: NgbModal
  ) { }

  ngOnInit(): void {
    this.getBooks();
  }

  getBooks(): void {
    this.bookService.getBooks().subscribe(books => {
      this.books = books;
    })
  }

  createBook(book: Book): void {
    this.bookService.createBook(this.newBook).subscribe();
  }

  deleteBook(id: string): void {
    this.bookService.deleteBook(id)
      .subscribe(() => {
        this.books = this.books.filter(Book => Book.id != id);
      });
  }

  updateBook(book: Book) {
    this.bookService.updateBook(book)
      .subscribe((updatedBook: Book) => {
        let existingBook = this.books.find(Book => Book.id === updatedBook.id);
        Object.assign(existingBook, updatedBook);
      });
  }

  openModal() {
    const ref = this.modalService.open(CreateModalComponent, ngbModalOptions);
    ref.componentInstance.book = null;
    ref.componentInstance.passEntry.subscribe((receivedBook) => {
      this.bookService.createBook(receivedBook).subscribe(() => {
        this.getBooks();
      });
    });
  }

  edit(book: Book) {
    if (book) {
      const ref = this.modalService.open(CreateModalComponent, ngbModalOptions);
      ref.componentInstance.editingBook = book;
      ref.componentInstance.passEntry.subscribe((receivedBook) => {
        this.bookService.updateBook(receivedBook).subscribe(() => {
          this.getBooks();
        });
      });
    }

  }

  delete(id: string) {
    this.bookService.deleteBook(id).subscribe(() => {
      this.getBooks();
    });

  }

}