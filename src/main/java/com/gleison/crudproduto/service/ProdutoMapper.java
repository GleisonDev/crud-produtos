package com.gleison.crudproduto.service;

import com.gleison.crudproduto.model.Produto;
import com.gleison.crudproduto.model.ProdutoRequestDTO;
import com.gleison.crudproduto.model.ProdutoResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProdutoMapper {

    public Produto toEntity(ProdutoRequestDTO dto) {
        if (dto == null) return null;

        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        produto.setEstoque(dto.getEstoque());
        return produto;
    }

    public ProdutoResponseDTO toResponseDTO(Produto produto) {
        if (produto == null) return null;

        return ProdutoResponseDTO.builder()
                .id(produto.getId())
                .nome(produto.getNome())
                .preco(produto.getPreco())
                .estoque(produto.getEstoque())
                .build();
    }

    public List<ProdutoResponseDTO> toResponseDTOList(List<Produto> produtos) {
        return produtos.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }
}
