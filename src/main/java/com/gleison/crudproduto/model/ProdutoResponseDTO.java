package com.gleison.crudproduto.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Schema(name = "ProdutoResponse", description = "Objeto retornado ao consultar os produtos")
@Data
@Builder
public class ProdutoResponseDTO {

    @Schema(description = "Identificador único do produto", example = "1")
    private Long id;

    @Schema(description = "Nome do produto", example = "Notebook Dell Inspiron 15")
    private String nome;

    @Schema(description = "Preço do produto", example = "3500.00")
    private Double preco;

    @Schema(description = "Quantidade disponível em estoque", example = "10")
    private Integer estoque;

}
