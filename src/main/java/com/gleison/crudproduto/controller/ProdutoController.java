package com.gleison.crudproduto.controller;

import com.gleison.crudproduto.model.ProdutoRequestDTO;
import com.gleison.crudproduto.model.ProdutoResponseDTO;
import com.gleison.crudproduto.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
@Tag(name = "Produtos", description = "Gerenciamento de Produtos")
public class ProdutoController {

    private final ProdutoService service;

    @PostMapping
    @Operation(summary = "Criar um novo produto", description = "Registra um novo produto no sistema")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Produto criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    public ResponseEntity<ProdutoResponseDTO> criarProduto(@Valid @RequestBody ProdutoRequestDTO produtoDTO) {
        ProdutoResponseDTO novoProduto = service.salvar(produtoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar produto por ID", description = "Recupera os detalhes de um produto pelo seu identificador")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Produto encontrado"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    public ResponseEntity<ProdutoResponseDTO> buscarPorId(@PathVariable Long id) {
        ProdutoResponseDTO produto = service.buscarPorId(id);
        return ResponseEntity.ok(produto);
    }

    @GetMapping
    @Operation(summary = "Listar todos os produtos", description = "Retorna a lista de produtos cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    public ResponseEntity<List<ProdutoResponseDTO>> listarProdutos() {
        List<ProdutoResponseDTO> produtos = service.listarTodos();
        return ResponseEntity.ok(produtos);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar produto", description = "Atualiza os dados de um produto existente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    public ResponseEntity<ProdutoResponseDTO> atualizarProduto(
            @PathVariable Long id,
            @Valid @RequestBody ProdutoRequestDTO produtoDTO) {

        ProdutoResponseDTO produtoAtualizado = service.atualizar(id, produtoDTO);
        return ResponseEntity.ok(produtoAtualizado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar produto", description = "Remove um produto do sistema pelo seu identificador")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Produto deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
