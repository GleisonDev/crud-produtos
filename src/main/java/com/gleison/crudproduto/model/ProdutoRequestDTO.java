package com.gleison.crudproduto.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Schema(name = "ProdutoRequest", description = "Objeto usado para criar ou atualizar um produto")
@Data
public class ProdutoRequestDTO {

    @Schema(description = "Nome do produto", example = "Notebook Dell Inspiron 15")
    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @Schema(description = "Preço do produto", example = "3500.00")
    @NotNull(message = "O preço é obrigatório")
    @Min(value = 0, message = "O preço não pode ser negativo")
    private Double preco;

    @Schema(description = "Quantidade disponível em estoque", example = "10")
    @NotNull(message = "A quantidade é obrigatória")
    @Min(value = 0, message = "A quantidade não pode ser negativa")
    private Integer estoque;

}
