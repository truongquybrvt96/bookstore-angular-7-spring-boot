package com.ltq.bookstore;

import com.ltq.bookstore.models.Book;
import com.ltq.bookstore.repositories.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

// EACH TIME YOU START THE SERVER, DATABASE RECORDS WILL BE RE-INIT.
public class BookstoreApplication implements CommandLineRunner {

	@Autowired
	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		bookRepository.deleteAll();
		bookRepository.save(new Book("Bạn Đắt Giá Bao Nhiêu?",
				"https://salt.tikicdn.com/cache/200x200/ts/product/87/c9/c0/bfebf4adcb31c8eb5c39fd3779cc4b68.jpg",
				"Vãn Tình", 99000f, 4.8f));

		bookRepository.save(new Book("Tuổi Trẻ Đáng Giá Bao Nhiêu",
				"https://salt.tikicdn.com/cache/200x200/media/catalog/product/t/u/tuoi-tre-dang-gia-bao-nhieu-u547-d20161012-t113832-888179.u3059.d20170616.t095744.390222.jpg",
				"Rosie Nguyễn", 70000f, 4.9f));

		bookRepository.save(new Book("Nhà Giả Kim",
				"https://salt.tikicdn.com/cache/200x200/media/catalog/product/i/m/img117.u3059.d20170616.t100547.729023.jpg",
				"Paulo Coelho", 69000f, 5f));

		bookRepository.save(new Book("Đắc Nhân Tâm (Khổ Lớn)",
				"https://salt.tikicdn.com/cache/200x200/ts/product/2e/eb/ad/9558a365adde6688d4c71a200d78310c.jpg",
				"Dale Carnegie", 76000f, 5f));

		bookRepository.save(new Book("Khí Chất Bao Nhiêu, Hạnh Phúc Bấy Nhiêu",
				"https://salt.tikicdn.com/cache/200x200/ts/product/34/0f/8b/9454467ac316ea683f93ff25405eee34.jpg",
				"Vãn Tình", 119000f, 4.7f));

		bookRepository.save(new Book("\"Hack\" Não 1500 Từ Tiếng Anh",
				"https://salt.tikicdn.com/cache/200x200/ts/product/83/e2/c8/d86894e313446165e5a0ceff531942ef.jpg",
				"Nguyễn Văn Hiệp (Chủ biên)", 495000f, 4.1f));

		bookRepository.save(new Book("Sống Thực Tế Giữa Đời Thực Dụng",
				"https://salt.tikicdn.com/cache/200x200/ts/product/25/d6/2c/f88080bba78a779fb78e1b76b73a9813.jpg",
				"Mễ Mông", 98000f, 4.5f));
	}
}

//// RUN AS NORMAL.
// public class BookstoreApplication {
// public static void main(String[] args) {
// SpringApplication.run(BookstoreApplication.class, args);
// }
// }
