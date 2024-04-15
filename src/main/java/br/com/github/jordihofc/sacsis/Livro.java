package br.com.github.jordihofc.sacsis;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
public class Livro {

    @Id//indica q esse atributo eh a chave primária
    @GeneratedValue//o valor sera gerado automaticamente pelo bd
    private Long id;

    @NotBlank
    @Size(max = 35)
    private String title;
    @NotBlank
    @Size(min = 90)
    private String description;
    @NotBlank
    private String isbn;
    @NotNull
    @Positive
    private BigDecimal price;

    public Livro(String title, String description, String isbn, BigDecimal price) {
        this.title = title;
        this.description = description;
        this.isbn = isbn;
        this.price = price;
    }

    @Deprecated
    public Livro() {}//contrutor vazio por exigencia do jpa

    public Long getId() {return id;}
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
