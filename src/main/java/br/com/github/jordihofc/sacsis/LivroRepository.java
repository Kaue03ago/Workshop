package br.com.github.jordihofc.sacsis;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    // jpa repository é uma interface q ja tem varios metodos prontos
    //para fazer operações no banco de dados
    //o primeiro parametro é a entidade q vc quer manipular e o segundo é
    // o tipo da chave primaria


}
