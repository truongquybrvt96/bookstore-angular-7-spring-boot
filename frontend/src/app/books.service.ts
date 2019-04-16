import { Injectable } from '@angular/core';
import { Book } from './book';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class BookService {
  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getBooks() {
    return this.http.get<Book[]>(this.baseUrl + '/api/books/');
  }

  createBook(book: Book) {
    return this.http.post(this.baseUrl + '/api/books/', book);
  }

  updateBook(book: Book) {
    return this.http.put(this.baseUrl + '/api/books/' + book.id, book);
  }

  deleteBook(id: string) {
    return this.http.delete(this.baseUrl + '/api/books/' + id);
  }
}