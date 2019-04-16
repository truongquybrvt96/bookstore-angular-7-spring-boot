import { Component, OnInit, Input, Output } from '@angular/core';
import { EventEmitter } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { Book } from 'app/book';

@Component({
  selector: 'app-create-modal',
  templateUrl: './create-modal.component.html',
  styleUrls: ['./create-modal.component.css']
})
export class CreateModalComponent implements OnInit {
  private bookForm = this.fb.group({
    title: ['', Validators.required],
    author: ['', Validators.required],
    imageSrc: [''],
    price: ['', [Validators.required, Validators.min(1)]],
    rating: ['', [Validators.min(0), Validators.max(5), Validators.required]]
  });
  @Input() public book;
  @Input() public editingBook;
  @Output() passEntry: EventEmitter<any> = new EventEmitter();
  constructor(
    private activeModel: NgbActiveModal,
    private fb: FormBuilder
  ) { }

  ngOnInit() {
    if (this.book) {
      this.bookForm.patchValue({
        title: this.book.title,
        author: this.book.author,
        imageSrc: this.book.imageSrc,
        price: this.book.price,
        rating: this.book.rating
      });
    }
    else if (this.editingBook) {
      this.bookForm.patchValue({
        title: this.editingBook.title,
        author: this.editingBook.author,
        imageSrc: this.editingBook.imageSrc,
        price: this.editingBook.price,
        rating: this.editingBook.rating
      });
    }
  }

  get title() { return this.bookForm.get('title'); }
  get author() { return this.bookForm.get('author'); }
  get imageSrc() { return this.bookForm.get('imageSrc'); }
  get price() { return this.bookForm.get('price'); }
  get rating() { return this.bookForm.get('rating'); }

  onSubmit() {
    const savedBook = this.bookForm.value;
    if (this.editingBook)
      savedBook.id = this.editingBook.id;
    this.passEntry.emit(savedBook);
    this.activeModel.close();
  }

}
