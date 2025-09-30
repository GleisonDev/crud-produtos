# 🚀 API RESTful para Gestão de Produtos (`crud-produto`)

Este é um projeto de **portfólio** que implementa uma **API RESTful completa** (CRUD: Criar, Ler, Atualizar, Deletar) para o gerenciamento de produtos. Desenvolvido com **Spring Boot 3**, o projeto segue padrões de arquitetura limpa, validação de dados robusta e inclui documentação automática via Swagger.

## 🎯 Destaques e Objetivos de Aprendizado

* Implementação do padrão **Service-Controller** para separação de responsabilidades.
* Uso de **Data Transfer Objects (DTOs)** e **Mappers** para isolamento de camadas e segurança de dados.
* Configuração e persistência de dados utilizando **Spring Data JPA**.
* Validação de *payloads* de requisição com o padrão **Jakarta Bean Validation**.
* Exposição de documentação interativa da API via **Springdoc OpenAPI (Swagger UI)**.

---

## 💻 Stack Tecnológica (Apresentação Profissional)

Demonstração de proficiência no ecossistema moderno do Java/Spring:

| Categoria | Tecnologia | Versão | Foco de Proficiência |
| :--- | :--- | :--- | :--- |
| **Linguagem** | **Java** | 17 | Uso de recursos modernos do Java para código conciso e legível. |
| **Framework** | **Spring Boot** | 3.5.6 | Experiência com **auto-configuração** e *starters* do ecossistema. |
| **Persistência** | **Spring Data JPA** | 3.x | **Mapeamento Objeto-Relacional** (ORM) e consultas eficientes. |
| **Documentação** | **Springdoc (Swagger)** | 2.8.5 | Geração automática de documentação **OpenAPI 3**, essencial para APIs. |
| **Utils** | **Lombok** | 1.18.x | Redução de código *boilerplate* para aumentar a manutenibilidade. |
| **Banco de Dados** | **H2 Database** | Runtime | **Database em memória** configurada para o ambiente de desenvolvimento. |

---

## ⚙️ Como Rodar a Aplicação Localmente

### Pré-requisitos

* **Java Development Kit (JDK) 17** ou superior.
* **Apache Maven** (para o build do projeto).

### 1. Clonagem e Execução

Para configurar e iniciar a API em um único fluxo de trabalho, utilize os seguintes comandos no seu terminal:

```bash
# 1. Clona o repositório para a sua máquina
git clone https://github.com/GleisonDev/crud-produtos.git

# 2. Navega para o diretório do projeto
cd crud-produtos

# 3. Limpa, compila e resolve todas as dependências do Maven
mvn clean install

# 4. Inicia a aplicação Spring Boot na porta 8080
mvn spring-boot:run
```
A API estará acessível em http://localhost:8080.

## 🌐 Endpoints da API e Documentação
### Documentação Interativa (Swagger UI)
Todos os endpoints estão documentados e podem ser testados diretamente na interface gráfica, o que facilita a integração com front-end ou outros serviços:

* **URL**: http://localhost:8080/swagger-ui.html

### Endpoints Principais (`/produtos`)

| Método | Rota | Descrição Funcional | Retorno Comum |
| :--- | :--- | :--- | :--- |
| **`POST`** | `/produtos` | Cria um novo produto, validando os dados de entrada. | `201 Created` |
| **`GET`** | `/produtos` | Lista todos os produtos cadastrados no banco de dados. | `200 OK` |
| **`GET`** | `/produtos/{id}` | Busca um produto específico pelo ID. | `200 OK` / `404 Not Found` |
| **`PUT`** | `/produtos/{id}` | Atualiza todas as informações do produto. | `200 OK` / `404 Not Found` |
| **`DELETE`** | `/produtos/{id}` | Remove o produto do sistema. | `204 No Content` |

## Exemplo de Payload(POST/PUT)
O corpo das requisições **`POST`** (criação) e **`PUT`** (atualização) deve seguir o formato JSON abaixo, conforme as regras de validação da API:

```json
{
    "nome": "Smartphone Modelo X",
    "preco": 1299.99,
    "estoque": 15
}
```

### ✍️ Autor
Este projeto foi desenvolvido por:

Edilgleidson Oliveira Silva

E-mail: gleisondev5690@gmail.com

LinkedIn: https://www.linkedin.com/in/edilgleidson-oliveira-7696416b/

GitHub: https://github.com/GleisonDev
