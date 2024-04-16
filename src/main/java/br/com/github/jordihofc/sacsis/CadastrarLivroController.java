package br.com.github.jordihofc.sacsis;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.math.BigDecimal;


@RestController
public class CadastrarLivroController {
    private final LivroRepository repository;//injeção de dependencia, criando repository

    public CadastrarLivroController(LivroRepository repository){
        this.repository = repository;//
    }

    @PostMapping("/livros")
    public ResponseEntity<?> cadastrar(@RequestBody @Valid LivroRequest request){//request é o obj q o Spring vai criar a partir
        // response eh a resposta q o Spring vai dar
        //ao colocar as validações no livro, eh necessario colocar @Valid para q funcione

        System.out.println(request);

        Livro livro = request.toModel();
        repository.save(livro);//o método save eh herdado de JpaRepository

        return ResponseEntity.status(HttpStatus.CREATED).build();//para poder retornar um entity, precisa colocas o response entity
    }




}
