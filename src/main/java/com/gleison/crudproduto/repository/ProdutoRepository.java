package com.gleison.crudproduto.repository;

import com.gleison.crudproduto.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
