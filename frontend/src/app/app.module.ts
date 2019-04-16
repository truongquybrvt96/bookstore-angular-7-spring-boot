import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';

import { BooksComponent } from './books.component';
import { BookService } from './books.service';
import { CreateModalComponent } from './create-modal/create-modal.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
@NgModule({
  declarations: [
    AppComponent,
    BooksComponent,
    CreateModalComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    NgbModule,
    ReactiveFormsModule
  ],
  providers: [BookService],
  bootstrap: [AppComponent],
  entryComponents: [CreateModalComponent]
})
export class AppModule { }