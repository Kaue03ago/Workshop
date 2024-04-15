package br.com.github.jordihofc.sacsis;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;


@RestController
public class CadastrarLivroController {
    private final LivroRepository repository;

    public CadastrarLivroController(LivroRepository repository){
        this.repository = repository;//injeção de dependência?
    }

    @PostMapping("/livros")
    public void cadastrar(@RequestBody Livro request){//request é o obj q o Spring vai criar a partir do JSON q o cliente enviar
       String title = request.getTitle();//usa o request para pegar o título
        if(title == null || title.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "the title cannot be done");
        }
        if (title.length()>35){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "the title field must not be longer than 35 characters");

        }

        String description = request.getDescription();

        if (description == null || description.isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "the description cannot be done");

        }
        if(description.length()>90){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "the description field must not be longer than 200 characters");

        }

        String isbn = request.getIsbn();
        if(isbn == null || isbn.isBlank()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "the isbn cannot be done");

        }

        if(request.getPrice() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "the price cannot be done");

        }
        if(request.getPrice().compareTo(BigDecimal.ZERO)<= 0 ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "the price must be greater than zero");
        }

        repository.save(request);//o método save eh herdado de JpaRepository
    }


}
