package br.com.github.jordihofc.sacsis;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.awt.print.Book;
import java.math.BigDecimal;

public class LivroRequest {

        @NotBlank
        @Size(max = 35)
        private String title;
        @NotBlank
        @Size(min = 90)
        private String description;
        @NotBlank
        private String isbn;
        @NotBlank
        @Positive
        private BigDecimal price;




        public Livro toModel(){
            Livro newBook = new Livro();

//            newBook.setTitle(title);
//            newBook.setDescription(description);
//            newBook.setIsbn(isbn);   NAO PRECISA MAIS, TEM CONTRUCT
//            newBook.setPrice(price);

            return new Livro(title, description, isbn, price);
        }

        public String getTitle() {
            return title;
        }
        public String getDescription() {
            return description;
        }
        public String getIsbn() {
            return isbn;
        }
        public BigDecimal getPrice() {
            return price;
        }


}
