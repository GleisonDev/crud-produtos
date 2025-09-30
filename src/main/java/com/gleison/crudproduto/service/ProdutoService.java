package com.gleison.crudproduto.service;

import com.gleison.crudproduto.exception.RecursoNaoEncontradoException;
import com.gleison.crudproduto.model.Produto;
import com.gleison.crudproduto.model.ProdutoRequestDTO;
import com.gleison.crudproduto.model.ProdutoResponseDTO;
import com.gleison.crudproduto.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;
    private final ProdutoMapper mapper;

    public ProdutoResponseDTO salvar(ProdutoRequestDTO dto) {

        Produto produtoParaSalvar = mapper.toEntity(dto);

        Produto produtoSalvo = repository.save(produtoParaSalvar);

        return mapper.toResponseDTO(produtoSalvo);
    }

    public ProdutoResponseDTO buscarPorId(Long id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto ID " + id + " não encontrado."));

        return mapper.toResponseDTO(produto);
    }

    public List<ProdutoResponseDTO> listarTodos() {
        List<Produto> produtos = repository.findAll();

        return mapper.toResponseDTOList(produtos);
    }

    public ProdutoResponseDTO atualizar(Long id, ProdutoRequestDTO dto) {
        Produto produtoEntity = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto ID " + id + " não encontrado."));

        if (dto.getNome() != null) produtoEntity.setNome(dto.getNome());
        if (dto.getPreco() != null) produtoEntity.setPreco(dto.getPreco());
        if (dto.getEstoque() != null) produtoEntity.setEstoque(dto.getEstoque());

        Produto produtoAtualizado = repository.save(produtoEntity);

        return mapper.toResponseDTO(produtoAtualizado);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Produto ID " + id + " não encontrado para exclusão.");
        }
        repository.deleteById(id);
    }
}
